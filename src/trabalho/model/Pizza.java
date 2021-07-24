package trabalho.model;

import java.util.List;
import trabalho.model.dao.FormaDAO;
import trabalho.model.dao.PedidoDAO;
import trabalho.model.dao.SaborDAO;
import trabalho.model.exceptions.DAOException;

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
    
    public Forma getForma() throws DAOException{
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
