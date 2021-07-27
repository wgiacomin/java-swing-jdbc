package app.delivery.model.beans.formatos;

public abstract class FormatoAbstract {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double area();
}