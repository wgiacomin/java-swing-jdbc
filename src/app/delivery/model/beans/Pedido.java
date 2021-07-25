package app.delivery.model.beans;

import app.delivery.model.beans.Cliente;
import app.delivery.model.dao.ClienteDAO;
import app.exceptions.DAOException;

public class Pedido {
    private int id;
    private Cliente cliente;

    public Pedido() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}