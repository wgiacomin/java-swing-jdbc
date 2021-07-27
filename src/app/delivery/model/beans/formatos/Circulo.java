package app.delivery.model.beans.formatos;

public class Circulo extends FormatoAbstract {
    private double raio;

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio;
    }
}
