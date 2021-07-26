package app.delivery.model.dao;

import app.delivery.model.beans.Cliente;
import app.delivery.model.beans.Pedido;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.delivery.model.dao.utils.ConnectionFactory;

public class PedidoDAO implements DAOInterface<Pedido> {

    private static final String QUERY_BUSCAR = "SELECT id, id_cliente FROM pedido WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, id_cliente FROM pedido;";
    private static final String QUERY_BUSCAR_POR_CLIENTE = "SELECT id, id_cliente FROM pedido WHERE id_cliente = ?;";
    private static final String QUERY_INSERIR = "INSERT INTO pedido(id_cliente) VALUES (?);";
    private static final String QUERY_REMOVER = "DELETE FROM pedido WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE pedido SET id_cliente = ? WHERE id = ?;";

    private Connection con = null;

    public PedidoDAO() throws DAOException {
        ConnectionFactory factory = new ConnectionFactory();
        con = factory.getConnection();
    }

    private Pedido extrairPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();

        pedido.setId(rs.getInt("id"));
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id_cliente"));
        pedido.setCliente(cliente);
        return pedido;
    }

    @Override
    public Pedido buscar(Pedido pedido) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, pedido.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pedido = extrairPedido(rs);
                return pedido;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria de pedido: " + pedido.getId(), e);
        }
    }

    @Override
    public List<Pedido> buscarTodos() throws DAOException {
        List<Pedido> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairPedido(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os pedidos: "
                    + QUERY_BUSCAR_TODOS, e);
        }
    }

    public List<Pedido> buscarPorCliente(Cliente cliente) throws DAOException {
        List<Pedido> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_CLIENTE)) {
            st.setInt(1, cliente.getId());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairPedido(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando pedidos do cliente: " + cliente.getId(), e);
        }
    }

    @Override
    public void inserir(Pedido pedido) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setInt(1, pedido.getCliente().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar pedido: "
                    + QUERY_INSERIR, e);
        }
    }

    @Override
    public void remover(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar pedido: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(Pedido pedido) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setInt(1, pedido.getCliente().getId());
            st.setInt(2, pedido.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar pedido: "
                    + QUERY_EDITAR, e);
        }
    }

}