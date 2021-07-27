package app.delivery.controller.pizza;

import app.delivery.model.beans.Sabor;
import app.delivery.model.dao.SaborDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class SaborController {

    public static List<Sabor> buscarTodos() {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            SaborDAO bd = new SaborDAO(factory.getConnection());
            List<Sabor> sabores = bd.buscarTodos();
            return sabores;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
