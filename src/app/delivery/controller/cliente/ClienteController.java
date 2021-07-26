package app.delivery.controller.cliente;

import app.delivery.model.beans.Cliente;
import app.delivery.model.dao.ClienteDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.Iterator;
import java.util.List;

public class ClienteController {

    public static List<Cliente> buscarTodos() {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            List<Cliente> clientes = bd.buscarTodos();
            return clientes;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Cliente> filtrarDado(String nome, String sobrenome, String telefone) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            List<Cliente> clientes = bd.buscarTodos();

            Iterator<Cliente> i;
            if (!nome.isEmpty()) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getNome().matches(nome)) {
                        i.remove();
                    }
                }
            }

            if (!sobrenome.isEmpty()) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getSobrenome().matches(sobrenome)) {
                        i.remove();
                    }
                }
            }

            if (!telefone.isEmpty()) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getTelefone().equals(telefone)) {
                        i.remove();
                    }
                }
            }

            return clientes;
        } catch (DAOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
