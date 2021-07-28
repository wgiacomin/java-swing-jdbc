package app.delivery.model.beans;

import app.delivery.model.beans.formatos.FormatoAbstract;
import java.util.List;
import java.lang.Math;

public class Pizza {

    private int id;
    private Pedido pedido;
    private FormatoAbstract formato;
    private List<Sabor> sabores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormatoAbstract getFormato() {
        return formato;
    }

    public void setFormato(FormatoAbstract formato) {
        this.formato = formato;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }

    public double calcPreco() {
        double preco = 0;
        for (int i = 0; i < sabores.size(); i++) {
            preco += ((sabores.get(i).getTipo().getCusto() * this.getFormato().area()) / sabores.size());
        }
        
        return Math.floor(preco * 100) / 100;
    }
    
    public int getSaboresSize(){
        return sabores.size();
    }

}
