package app.delivery.model.beans.formatos;

import app.exceptions.TamanhoException;

public class Circulo extends FormatoAbstract {

    @Override
    public double area() {
        return Math.PI * this.getDimension() * this.getDimension();
    }

    @Override
    public void setArea(double area) throws TamanhoException {
        this.setDimension(Math.sqrt(area / Math.PI));
    }

    @Override
    public void setDimension(double dimension) throws TamanhoException {
        if (dimension < 7 || dimension > 23) {
            throw new TamanhoException();
        }
        super.setDimension(dimension);
    }
}
