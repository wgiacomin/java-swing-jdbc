package app.delivery.model.beans.formatos;

import app.exceptions.TamanhoException;

public class Quadrado extends FormatoAbstract {
    @Override
    public double area() {
        return this.getDimension() * this.getDimension();
    }

    @Override
    public void setArea(double area) throws TamanhoException{
        this.setDimension(Math.sqrt(area));
    }
    
    @Override
    public void setDimension(double dimension) throws TamanhoException{
        if (dimension < 10 || dimension > 40){
            throw new TamanhoException();
        }
        super.setDimension(dimension);
    }
}
