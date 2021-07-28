package app.delivery.model.beans.formatos;

import app.exceptions.TamanhoException;

public class Triangulo extends FormatoAbstract {

    @Override
    public double area() {
        return ((this.getDimension() * this.getDimension()) * Math.sqrt(3)) / 4;
    }

    @Override
    public void setArea(double area) throws TamanhoException {
        this.setDimension(Math.sqrt(area * 4 / Math.sqrt(3)));
    }

    @Override
    public void setDimension(double dimension) throws TamanhoException {
        if (dimension < 20 || dimension > 60) {
            throw new TamanhoException();
        }
        super.setDimension(dimension);
    }
}
