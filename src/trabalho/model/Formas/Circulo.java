package trabalho.model.Formas;

import trabalho.model.Forma;

public class Circulo extends Forma {
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
