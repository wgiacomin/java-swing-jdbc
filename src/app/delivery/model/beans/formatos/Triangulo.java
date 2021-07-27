package app.delivery.model.beans.formatos;

public class Triangulo extends FormatoAbstract {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return ((lado * lado) * Math.sqrt(3))/4;
    }
}
