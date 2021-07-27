package app.delivery.model.beans.formatos;

public class Quadrado extends FormatoAbstract {
    @Override
    public double area() {
        return this.getDimension() * this.getDimension();
    }
}
