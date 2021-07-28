package app.delivery.model.beans.formatos;

public class Circulo extends FormatoAbstract {
    @Override
    public double area() {
        return Math.PI * this.getDimension() * this.getDimension();
    }

    @Override
    public void setArea(double area) {
       this.setDimension(Math.sqrt(area/Math.PI));
    }
}
