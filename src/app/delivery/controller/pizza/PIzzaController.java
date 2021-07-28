package app.delivery.controller.pizza;

import app.delivery.controller.pedido.PedidoController;
import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.dao.FormaDAO;
import app.delivery.model.dao.PizzaDAO;
import app.delivery.model.dao.PizzaSaborDAO;
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

    public static void editar(Pizza pizza) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PizzaSaborDAO bd = new PizzaSaborDAO(factory.getConnection());
            bd.removerPizza(pizza.getId());
            bd.inserir(pizza);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static Pedido adicionar(Pizza pizza, Pedido pedido) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            if (pedido.getId() == -1){
                pedido.setTotal(pizza.calcPreco());
                pedido = PedidoController.novoPedido(pedido);
            }
            
            FormaDAO fd = new FormaDAO(factory.getConnection());
            int i  = fd.inserir(pizza.getFormato());
            
            pizza.setPedido(pedido);
            pizza.getFormato().setId(i);
            PizzaDAO qd = new PizzaDAO(factory.getConnection());
            pizza.setId(qd.inserir(pizza));
            PizzaSaborDAO bd = new PizzaSaborDAO(factory.getConnection());
            bd.inserir(pizza);
            return pedido;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
