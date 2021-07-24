package trabalho.model;

import trabalho.model.dao.PizzaDAO;
import trabalho.model.exceptions.DAOException;

public abstract class Forma {
    private int id;
    private int idPizza;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public Pizza getPizza() throws DAOException {
        PizzaDAO pizzaDAO = new PizzaDAO();
        Pizza pizza = new Pizza();
        pizza.setId(idPizza);
        pizzaDAO.buscar(pizza);
        return pizza;
    }

    public abstract double area();
}