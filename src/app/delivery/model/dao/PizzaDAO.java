package app.delivery.model.dao;

import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.delivery.model.dao.utils.ConnectionFactory;

public class PizzaDAO implements DAOInterface<Pizza> {

    private static final String QUERY_BUSCAR = "SELECT id, id_pedido FROM pizza WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, id_pedido FROM pizza;";
    private static final String QUERY_BUSCAR_POR_PEDIDO = "SELECT id, id_pedido FROM pizza WHERE id_pedido = ?;";
    private static final String QUERY_INSERIR = "INSERT INTO pizza(id_pedido) VALUES (?);";
    private static final String QUERY_REMOVER = "DELETE FROM pizza WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE pizza SET id_pedido = ? WHERE id = ?;";

    private Connection con = null;

    public PizzaDAO() throws DAOException {
        ConnectionFactory factory = new ConnectionFactory();
        con = factory.getConnection();
    }

    private Pizza extrairPizza(ResultSet rs) throws SQLException {
        Pizza pizza = new Pizza();

        pizza.setId(rs.getInt("id"));
        pizza.setIdPedido(rs.getInt("id_pedido"));
        return pizza;
    }

    @Override
    public Pizza buscar(Pizza pizza) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, pizza.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pizza = extrairPizza(rs);
                return pizza;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscand o pizza: " + pizza.getId(), e);
        }
    }

    @Override
    public List<Pizza> buscarTodos() throws DAOException {
        List<Pizza> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairPizza(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os pizzas: "
                    + QUERY_BUSCAR_TODOS, e);
        }
    }

    public List<Pizza> buscarPorPedido(Pedido pedido) throws DAOException {
        List<Pizza> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_PEDIDO)) {
            st.setInt(1, pedido.getId());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairPizza(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando pizzas do pedido: " + pedido.getId(), e);
        }
    }

    @Override
    public void inserir(Pizza pizza) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setInt(1, pizza.getPedido().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar pizza: "
                    + QUERY_INSERIR, e);
        }
    }

    @Override
    public void remover(Pizza pizza) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, pizza.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar pizza: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(Pizza pizza) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setInt(1, pizza.getPedido().getId());
            st.setInt(2, pizza.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar pizza: "
                    + QUERY_EDITAR, e);
        }
    }

}