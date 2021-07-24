package trabalho.model.dao;

import trabalho.model.Pedido;
import trabalho.model.Sabor;
import trabalho.model.dao.utils.DAOInterface;
import trabalho.model.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.model.Pizza;
import trabalho.model.dao.utils.ConnectionFactory;

public class SaborDAO implements DAOInterface<Sabor> {

    private static final String QUERY_BUSCAR = "SELECT id, nome FROM sabor WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome FROM sabor;";
    private static final String QUERY_BUSCAR_POR_PIZZA = "SELECT s.id, s.nome FROM ((pizza_sabor ps\n" +
                                                            "INNER JOIN sabor s ON ps.id_sabor = s.id)\n" +
                                                            "INNER JOIN pizza p ON ps.id_pizza = p.id)\n" +
                                                            "WHERE p.id = ?;";
    private static final String QUERY_INSERIR = "INSERT INTO sabor(nome) VALUES (?);";
    private static final String QUERY_REMOVER = "DELETE FROM sabor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE sabor SET nome = ? WHERE id = ?;";

    private Connection con = null;

    public SaborDAO() throws DAOException {
        ConnectionFactory factory = new ConnectionFactory();
        con = factory.getConnection();
    }

    private Sabor extrairSabor(ResultSet rs) throws SQLException {
        Sabor sabor = new Sabor();

        sabor.setId(rs.getInt("id"));
        sabor.setNome(rs.getString("nome"));
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
    
    public List<Sabor> buscarPorPizza(Pizza pizza) throws DAOException {
        List<Sabor> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_PIZZA)) {
            st.setInt(1, pizza.getId());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairSabor(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando sabores da pizza: " + pizza.getId(), e);
        }
    }

    @Override
    public void inserir(Sabor sabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, sabor.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar sabor: "
                    + QUERY_INSERIR, e);
        }
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
            st.setInt(2, sabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar sabor: "
                    + QUERY_EDITAR, e);
        }
    }

}