package app.delivery.model.beans.formatos;

import app.delivery.model.beans.Formato;

public class Circulo extends Formato {
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
