package app.delivery.model.beans.formatos;

public abstract class FormatoAbstract {
    private int id;
    private double dimension;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDimension(double dimension){
        this.dimension = dimension;
    }
    
    public abstract void setArea(double area);
    
    public double getDimension(){
        return this.dimension;
    }
    
    public abstract double area();
}