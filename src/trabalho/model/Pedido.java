package trabalho.model;

import trabalho.model.dao.ClienteDAO;
import trabalho.model.exceptions.DAOException;

public class Pedido {
    private int id;
    private int idCliente;

    public Pedido() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() throws DAOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        clienteDAO.buscar(cliente);
        return cliente;
    }
}