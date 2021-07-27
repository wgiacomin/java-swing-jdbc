package app.delivery.model.beans;

import app.delivery.model.beans.formatos.FormatoAbstract;
import app.delivery.model.beans.Pedido;
import java.util.List;
import app.delivery.model.dao.FormaDAO;
import app.delivery.model.dao.PedidoDAO;
import app.delivery.model.dao.SaborDAO;
import app.exceptions.DAOException;

public class Pizza {
    private int id;
    private Pedido pedido;
    private FormatoAbstract formato;
    private List<Sabor> sabores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormatoAbstract getFormato() {
        return formato;
    }

    public void setFormato(FormatoAbstract formato) {
        this.formato = formato;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }

}
