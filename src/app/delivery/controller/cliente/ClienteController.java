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

    public static boolean remover(Cliente cliente) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            bd.remover(cliente);
            return true;
        } catch (DAOException e) {
            return false;
        }
    }

    public static void editar(Cliente cliente) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            bd.editar(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionar(Cliente cliente) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            bd.inserir(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> filtrarDado(String[] filters) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            ClienteDAO bd = new ClienteDAO(factory.getConnection());
            List<Cliente> clientes = bd.buscarTodos();

            Iterator<Cliente> i;
            if (!filters[0].equals("")) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getNome().matches("(?i)^.*" + filters[0] + ".*$")) {
                        i.remove();
                    }
                }
            }

            if (!filters[1].equals("")) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getSobrenome().matches("(?i)^.*" + filters[1] + ".*$")) {
                        i.remove();
                    }
                }
            }

            if (!filters[2].equals("")) {
                i = clientes.iterator();
                while (i.hasNext()) {
                    Cliente cliente = i.next();
                    if (!cliente.getTelefone().replaceAll("\\D+", "").matches("^.*" + filters[2].replaceAll("\\D+", "") + ".*$")) {
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
