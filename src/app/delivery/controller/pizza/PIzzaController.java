package app.delivery.controller.pizza;

import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.dao.PizzaDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class PIzzaController {

    public static List<Pizza> buscarTodosPorPedido(Pedido pedido) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PizzaDAO bd = new PizzaDAO(factory.getConnection());
            List<Pizza> pizzas = bd.buscarPorPedido(pedido);
            return pizzas;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
