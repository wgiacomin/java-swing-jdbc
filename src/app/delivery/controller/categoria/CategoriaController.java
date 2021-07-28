package app.delivery.controller.categoria;

import app.delivery.model.beans.TipoSabor;
import app.delivery.model.dao.TipoSaborDAO;
import app.delivery.model.dao.utils.ConnectionFactory;
import app.exceptions.DAOException;
import java.util.List;

public class CategoriaController {

    public static List<TipoSabor> buscarTodos() {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            TipoSaborDAO bd = new TipoSaborDAO(factory.getConnection());
            return bd.buscarTodos();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void editar(TipoSabor categoria) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            TipoSaborDAO bd = new TipoSaborDAO(factory.getConnection());
            bd.editar(categoria);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
