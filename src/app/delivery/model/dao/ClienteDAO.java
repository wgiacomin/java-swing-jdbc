package app.delivery.model.dao;

import app.delivery.model.beans.Cliente;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAOInterface<Cliente> {

    private static final String QUERY_BUSCAR = "SELECT id, nome, sobrenome, telefone FROM cliente WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome, sobrenome, telefone FROM cliente;";
    private static final String QUERY_INSERIR = "INSERT INTO cliente(nome, sobrenome, telefone) VALUES (?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM cliente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ? WHERE id = ?;";

    private Connection con = null;

    public ClienteDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar.");
        }
        this.con = con;
    }

    private Cliente extrairCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setSobrenome(rs.getString("descricao"));
        cliente.setTelefone(rs.getString("peso"));
        return cliente;
    }

    @Override
    public Cliente buscar(Cliente cliente) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, cliente.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cliente = extrairCliente(rs);
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria de cliente: " + cliente.getId(), e);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws DAOException {
        List<Cliente> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairCliente(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os clientes: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    @Override
    public void inserir(Cliente cliente) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSobrenome());
            st.setString(3, cliente.getTelefone());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar cliente: "
                    + QUERY_INSERIR, e);
        }
    }

    @Override
    public void remover(Cliente cliente) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, cliente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar cliente: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(Cliente cliente) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSobrenome());
            st.setString(3, cliente.getTelefone());
            st.setInt(4, cliente.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar cliente: "
                    + QUERY_EDITAR, e);
        }
    }

}
