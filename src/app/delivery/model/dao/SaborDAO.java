package app.delivery.model.dao;

import app.delivery.model.beans.Sabor;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.delivery.model.beans.TipoSabor;

public class SaborDAO implements DAOInterface<Sabor> {

    private static final String QUERY_BUSCAR = "SELECT id, nome, id_tipo FROM sabor WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome, id_tipo FROM sabor ORDER BY nome ASC;";
    private static final String QUERY_BUSCAR_POR_PIZZA = "SELECT s.id, s.nome, id_tipo, ts.nome as tipo, ts.custo"
            + " FROM pizza_sabor ps\n"
            + "         INNER JOIN sabor s ON ps.id_sabor = s.id"
            + "         INNER JOIN pizza p ON ps.id_pizza = p.id"
            + "         INNER JOIN tipo_sabor ts on s.id_tipo = ts.id"
            + " WHERE p.id = ?;";
    private static final String QUERY_INSERIR = "INSERT INTO sabor(nome, id_tipo) VALUES (?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM sabor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE sabor SET nome = ?, id_tipo = ? WHERE id = ?;";

    private Connection con = null;

    public SaborDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar.");
        }
        this.con = con;
    }

    private Sabor extrairSabor(ResultSet rs) throws SQLException {
        Sabor sabor = new Sabor();
        TipoSabor tipo = new TipoSabor();

        sabor.setId(rs.getInt("id"));
        sabor.setNome(rs.getString("nome"));
        tipo.setId(rs.getInt("id_tipo"));
        sabor.setTipo(tipo);
        return sabor;
    }

    private Sabor extrairSaborComTipo(ResultSet rs) throws SQLException {
        Sabor sabor = new Sabor();
        TipoSabor tipo = new TipoSabor();

        sabor.setId(rs.getInt("id"));
        sabor.setNome(rs.getString("nome"));
        tipo.setNome(rs.getString("tipo"));
        tipo.setCusto(rs.getDouble("custo"));
        sabor.setTipo(tipo);
        return sabor;
    }

    @Override
    public Sabor buscar(Sabor sabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, sabor.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sabor = extrairSabor(rs);
                return sabor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscand o sabor: " + sabor.getId(), e);
        }
    }

    @Override
    public List<Sabor> buscarTodos() throws DAOException {
        List<Sabor> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairSabor(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os sabors: "
                    + QUERY_BUSCAR_TODOS, e);
        }
    }

    public List<Sabor> buscarPorPizza(int id) throws DAOException {
        List<Sabor> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_PIZZA)) {
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairSaborComTipo(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando sabores da pizza: " + id, e);
        }
    }

    @Override
    public int inserir(Sabor sabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, sabor.getNome());
            st.setInt(2, sabor.getTipo().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar sabor: "
                    + QUERY_INSERIR, e);
        }
        return 0;
    }

    @Override
    public void remover(Sabor sabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, sabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar sabor: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(Sabor sabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setString(1, sabor.getNome());
            st.setInt(2, sabor.getTipo().getId());
            st.setInt(3, sabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar sabor: "
                    + QUERY_EDITAR, e);
        }
    }

}
