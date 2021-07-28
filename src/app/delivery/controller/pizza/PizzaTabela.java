package app.delivery.controller.pizza;

import app.delivery.model.beans.Pizza;
import app.delivery.model.beans.formatos.Circulo;
import app.delivery.model.beans.formatos.Formatos;
import app.delivery.model.beans.formatos.Quadrado;
import app.delivery.model.beans.formatos.Triangulo;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PizzaTabela extends AbstractTableModel {

    private final String[] colunas = new String[]{"id", "Formato", "Dimensão (cm)", "Área (cm²)", "Preço do Item"};
    private List<Pizza> listaPizza;
    private final NumberFormat format;

    public PizzaTabela() {
        this.format = NumberFormat.getCurrencyInstance();
        this.listaPizza = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaPizza.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Pizza pizza = listaPizza.get(row);
        switch (col) {
            case 0:
                return pizza.getId();
            case 1:
                if (pizza.getFormato() instanceof Circulo) {
                    return Formatos.CIRCULO;
                }
                if (pizza.getFormato() instanceof Quadrado) {
                    return Formatos.QUADRADO;
                }
                if (pizza.getFormato() instanceof Triangulo) {
                    return Formatos.TRIANGULO;
                }
                return null;
            case 2:
                return (int) pizza.getFormato().getDimension();
            case 3:
                return (int) pizza.getFormato().area();
            case 4:
                return format.format(pizza.calcPreco());
            default:
                return null;
        }
    }

    public Pizza getPizza(int linha) {
        return listaPizza.get(linha);
    }

    public boolean removePizza(int linha) {
        listaPizza.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        return true;
    }

    public void refreshTabela(int id) {
        if (id == -1) {
            this.listaPizza = new ArrayList<>();
        } else {
            this.listaPizza = PizzaController.buscarTodosPorPedido(id);
        }
        this.fireTableDataChanged();
    }

    public String getValorTotal() {
        if (listaPizza.size() > 0) {
            double valor = 0;
            valor = listaPizza.stream().map(pizza -> pizza.calcPreco()).reduce(valor, (accumulator, _item) -> accumulator + _item);
            return format.format(valor);
        } else {
            return format.format(0);
        }
    }

    public double getValorTotalNumeric() {
        if (listaPizza.size() > 0) {
            double valor = 0;
            valor = listaPizza.stream().map(pizza -> pizza.calcPreco()).reduce(valor, (accumulator, _item) -> accumulator + _item);
            return valor;
        } else {
            return 0;
        }
    }
}
