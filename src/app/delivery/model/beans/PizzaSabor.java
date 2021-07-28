package app.delivery.model.beans;

public class PizzaSabor {
    
    private int id;
    private Pizza pizza;
    private Sabor sabor;

    public PizzaSabor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }
    
    
}
