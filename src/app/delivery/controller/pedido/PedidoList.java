package app.delivery.controller.pedido;

import app.delivery.model.beans.Cliente;
import app.delivery.model.beans.Pedido;
import java.util.List;
import javax.swing.DefaultListModel;

public class PedidoList extends DefaultListModel {

    private List<Pedido> listaPedidos;

    public PedidoList() {
        this.addElement("Novo");
    }

    public void filterCliente(Cliente cliente) {
        this.removeAllElements();
        this.addElement("Novo");
        listaPedidos = PedidoController.buscarTodosPorCliente(cliente);
        listaPedidos.forEach(e -> {
            this.addElement(String.valueOf(e.getId()));
        });
    }

    public int getPedidoId(int index) {
        if (index > 0) {
            return listaPedidos.get(index - 1).getId();
        }
        return -1;
    }
}
