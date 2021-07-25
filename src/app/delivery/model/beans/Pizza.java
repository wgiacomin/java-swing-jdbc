package app.delivery.model.beans;

import app.delivery.model.beans.Pedido;
import java.util.List;
import app.delivery.model.dao.FormaDAO;
import app.delivery.model.dao.PedidoDAO;
import app.delivery.model.dao.SaborDAO;
import app.exceptions.DAOException;

public class Pizza {
    private int id;
    private int idPedido;
    private int idForma;
    private List<Integer> idSabores;

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

    public int getIdForma() {
        return idForma;
    }

    public void setIdForma(int idForma) {
        this.idForma = idForma;
    }
    
    public Formato getForma() throws DAOException{
        FormaDAO formaDAO = new FormaDAO();
        return formaDAO.buscarPorId(idForma);
    }

    public List<Integer> getIdSabores() {
        return idSabores;
    }

    public void setIdSabores(List<Integer> idSabores) {
        this.idSabores = idSabores;
    }
    
    public List<Sabor> getSabores() throws DAOException {
        SaborDAO saborDAO = new SaborDAO();
        return saborDAO.buscarPorPizza(this);
    }
}
