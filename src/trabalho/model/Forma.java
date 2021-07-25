package trabalho.model;

import trabalho.model.dao.PizzaDAO;
import trabalho.model.exceptions.DAOException;

public abstract class Forma {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double area();
}