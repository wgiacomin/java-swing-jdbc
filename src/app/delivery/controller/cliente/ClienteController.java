package app.delivery.controller.cliente;

import app.delivery.model.beans.Cliente;
import app.delivery.model.dao.ClienteDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class ClienteController {

    public static List<Cliente> buscarTodos() throws DAOException {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            List<Cliente> clientes = bd.buscarTodos();
            return clientes;
        } 
    }

}
