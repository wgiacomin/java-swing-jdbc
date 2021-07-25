package app.delivery.model.beans.formatos;

import app.delivery.model.beans.Formato;

public class Triangulo extends Formato {
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
