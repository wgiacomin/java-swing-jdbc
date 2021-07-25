package app.delivery.model.beans;

public abstract class Formato {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double area();
}