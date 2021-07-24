package trabalho.model.Formas;

import trabalho.model.Forma;

public class Quadrado extends Forma {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }
}
