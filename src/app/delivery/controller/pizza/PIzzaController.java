package app.delivery.controller.pizza;

import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.dao.PizzaDAO;
import app.delivery.model.dao.SaborDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class PizzaController {

    public static List<Pizza> buscarTodosPorPedido(int id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PizzaDAO bd = new PizzaDAO(factory.getConnection());
            SaborDAO sb = new SaborDAO(factory.getConnection());
            List<Pizza> pizzas = bd.buscarPorPedido(pedido);
            for (Pizza pizza : pizzas) {
                pizza.setSabores(sb.buscarPorPizza(pizza.getId()));
            }
            return pizzas;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
