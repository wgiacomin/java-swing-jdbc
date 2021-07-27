package app.delivery.model.beans.formatos;

public class Circulo extends FormatoAbstract {
    @Override
    public double area() {
        return Math.PI * this.getDimension();
    }
}
