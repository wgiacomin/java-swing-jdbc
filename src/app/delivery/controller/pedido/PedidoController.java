package app.delivery.controller.pedido;

import app.delivery.model.beans.Cliente;
import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.dao.PedidoDAO;
import app.delivery.model.dao.PizzaDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class PedidoController {

    public static List<Pedido> buscarTodos() {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PedidoDAO bd = new PedidoDAO(factory.getConnection());
            List<Pedido> pedidos = bd.buscarTodos();
            return pedidos;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pedido> buscarTodosPorCliente(Cliente cliente) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PedidoDAO bd = new PedidoDAO(factory.getConnection());
            List<Pedido> pedidos = bd.buscarPorCliente(cliente);
            return pedidos;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Pedido novoPedido(Pedido pedido) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            PedidoDAO bd = new PedidoDAO(factory.getConnection());
            pedido.setId(bd.inserir(pedido));
            return pedido;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
