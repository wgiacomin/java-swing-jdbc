package trabalho.model;

import trabalho.model.dao.PedidoDAO;
import trabalho.model.exceptions.DAOException;

public class Pizza {
    private int id;
    private int idPedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido getPedido() throws DAOException {
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = new Pedido();
        pedido.setId(idPedido);
        pedidoDAO.buscar(pedido);
        return pedido;
    }
}
