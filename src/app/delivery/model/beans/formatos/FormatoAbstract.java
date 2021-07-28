package app.delivery.model.beans.formatos;

import app.exceptions.TamanhoException;

public abstract class FormatoAbstract {
    private int id;
    private double dimension;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDimension(double dimension) throws TamanhoException {
        this.dimension = dimension;
    }
    
    public abstract void setArea(double area) throws TamanhoException;
    
    public double getDimension(){
        return this.dimension;
    }
    
    public abstract double area();
}