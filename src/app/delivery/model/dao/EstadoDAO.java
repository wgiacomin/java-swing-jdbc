package app.delivery.model.dao;

import app.delivery.model.beans.estado.Estado;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements DAOInterface<Estado> {

    private static final String QUERY_BUSCAR_TODOS = "SELECT id, nome FROM estado;";

    private Connection con = null;

    public EstadoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar.");
        }
        this.con = con;
    }

    @Override
    public Estado buscar(Estado estado) throws DAOException {
        throw new DAOException("Não Implementado.");
    }

    @Override
    public List<Estado> buscarTodos() throws DAOException {
        List<Estado> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setEstado(rs.getString("nome"));
                lista.add(estado);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os formas: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    @Override
    public int inserir(Estado estado) throws DAOException {
        throw new DAOException("Não Implementado.");
    }

    @Override
    public void remover(Estado estado) throws DAOException {
        throw new DAOException("Não Implementado.");
    }

    @Override
    public void editar(Estado estado) throws DAOException {
        throw new DAOException("Não Implementado.");
    }

}
