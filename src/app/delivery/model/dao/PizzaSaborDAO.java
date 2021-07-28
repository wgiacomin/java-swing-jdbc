package app.delivery.model.dao;

import app.delivery.model.beans.Pizza;
import app.delivery.model.beans.PizzaSabor;
import app.delivery.model.beans.Sabor;
import app.delivery.model.dao.utils.DAOInterface;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaSaborDAO implements DAOInterface<PizzaSabor> {

    private static final String QUERY_BUSCAR = "SELECT id, id_pizza, id_sabor FROM pizza_sabor WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, id_pizza, id_sabor FROM pizza_sabor ORDER BY nome ASC;";
    private static final String QUERY_INSERIR = "INSERT INTO pizza_sabor(id_pizza, id_sabor) VALUES (?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM pizza_sabor WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE pizza_sabor SET id_pizza = ?, id_sabor = ? WHERE id = ?;";

    private Connection con = null;

    public PizzaSaborDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar.");
        }
        this.con = con;
    }

    private PizzaSabor extrairPizzaSabor(ResultSet rs) throws SQLException {
        PizzaSabor pizzaSabor = new PizzaSabor();
        Pizza pizza = new Pizza();
        Sabor sabor = new Sabor();

        pizzaSabor.setId(rs.getInt("id"));
        pizza.setId(rs.getInt("id_pizza"));
        pizzaSabor.setPizza(pizza);
        sabor.setId(rs.getInt("id_sabor"));
        pizzaSabor.setSabor(sabor);
        return pizzaSabor;
    }

    @Override
    public PizzaSabor buscar(PizzaSabor pizzaSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, pizzaSabor.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pizzaSabor = extrairPizzaSabor(rs);
                return pizzaSabor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando pizza/sabor: " + pizzaSabor.getId(), e);
        }
    }

    @Override
    public List<PizzaSabor> buscarTodos() throws DAOException {
        List<PizzaSabor> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairPizzaSabor(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os pizza/sabor: "
                    + QUERY_BUSCAR_TODOS, e);
        }
    }
    
    @Override
    public int inserir(PizzaSabor pizzaSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            st.setInt(1, pizzaSabor.getPizza().getId());
            st.setInt(2, pizzaSabor.getSabor().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar pizza/sabor: "
                    + QUERY_INSERIR, e);
        }
        return 0;
    }
    
    public int inserir(Pizza pizza) throws DAOException {
        ArrayList<Sabor> sabores = new ArrayList<>(pizza.getSabores());
        for(int i = 0; i < sabores.size(); i++){
            try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
                st.setInt(1, pizza.getId());
                st.setInt(2, sabores.get(i).getId());
                st.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Erro ao criar pizza/sabor: "
                        + QUERY_INSERIR, e);
            }
        }
        return 0;
    }

    @Override
    public void remover(PizzaSabor pizzaSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, pizzaSabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar pizza/sabor: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(PizzaSabor pizzaSabor) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            st.setInt(1, pizzaSabor.getPizza().getId());
            st.setInt(2, pizzaSabor.getSabor().getId());
            st.setInt(3, pizzaSabor.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar pizza/sabor: "
                    + QUERY_EDITAR, e);
        }
    }

}
