package app.delivery.model.beans.formatos;

public class Triangulo extends FormatoAbstract {
    @Override
    public double area() {
        return ((this.getDimension() * this.getDimension()) * Math.sqrt(3))/4;
    }

    @Override
    public void setArea(double area) {
        this.setDimension(Math.sqrt(area * 4 / Math.sqrt(3)));
    }
}
