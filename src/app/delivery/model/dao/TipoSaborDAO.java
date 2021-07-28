package app.delivery.model.dao;

import app.delivery.model.beans.TipoSabor;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.delivery.model.beans.Pizza;

public class TipoSaborDAO implements DAOInterface<TipoSabor> {

    private static final String QUERY_BUSCAR = "SELECT id, nome, custo FROM custo WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome, custo FROM tipo_sabor ORDER BY nome ASC;";
    private static final String QUERY_INSERIR = "INSERT INTO tipo_sabor(nome, custo) VALUES (?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM tipo_sabor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE tipo_sabor SET nome = ?, custo = ? WHERE id = ?;";

    private Connection con = null;

    public TipoSaborDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar.");
        }
        this.con = con;
    }

    private TipoSabor extrairTipoSabor(ResultSet rs) throws SQLException {
        TipoSabor tipoSabor = new TipoSabor();

        tipoSabor.setId(rs.getInt("id"));
        tipoSabor.setNome(rs.getString("nome"));
        tipoSabor.setCusto(rs.getDouble("custo"));
        return tipoSabor;
    }

    @Override
    public TipoSabor buscar(TipoSabor tipoSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, tipoSabor.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                tipoSabor = extrairTipoSabor(rs);
                return tipoSabor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando tipo de sabor: " + tipoSabor.getId(), e);
        }
    }

    @Override
    public List<TipoSabor> buscarTodos() throws DAOException {
        List<TipoSabor> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairTipoSabor(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os tipos de sabor: "
                    + QUERY_BUSCAR_TODOS, e);
        }
    }

    @Override
    public int inserir(TipoSabor tipoSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, tipoSabor.getNome());
            st.setDouble(2, tipoSabor.getCusto());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar tipo de sabor: "
                    + QUERY_INSERIR, e);
        }
        return 0;
    }

    @Override
    public void remover(TipoSabor tipoSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, tipoSabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar tipo de sabor: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(TipoSabor tipoSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setString(1, tipoSabor.getNome());
            st.setDouble(2, tipoSabor.getCusto());
            st.setInt(3, tipoSabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar tipo de sabor: "
                    + QUERY_EDITAR, e);
        }
    }

}
