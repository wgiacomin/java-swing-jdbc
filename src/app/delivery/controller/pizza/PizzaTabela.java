package app.delivery.controller.pizza;

import app.delivery.model.beans.Pizza;
import app.delivery.model.beans.formatos.Circulo;
import app.delivery.model.beans.formatos.Formatos;
import app.delivery.model.beans.formatos.Quadrado;
import app.delivery.model.beans.formatos.Triangulo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PizzaTabela extends AbstractTableModel {
    private final String[] colunas = new String[]{"id", "Formato", "Dimensão", "Área", "Preço Total"};
    private List<Pizza> listaPizza;
    
    public PizzaTabela() {
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
                if (pizza.getFormato() instanceof Circulo) { return Formatos.CIRCULO; }
                if (pizza.getFormato() instanceof Quadrado) { return Formatos.QUADRADO; }
                if (pizza.getFormato() instanceof Triangulo) { return Formatos.TRIANGULO; }
                return null;
            case 2:
                return pizza.getFormato().getDimension();
            case 3:
                return pizza.getFormato().area();
            case 4:
                return null;
            default:
                return null;
        }
    }

//    public Pizza getCliente(int linha) {
//        return listaPizza.get(linha);
//    }
//
//    public void addCliente(Pizza pizza) {
//        ClienteController.adicionar(cliente);
//        listaCliente.add(cliente);
//        this.fireTableRowsInserted(this.listaCliente.size() -1, this.listaCliente.size() -1);
//    }
//    
//    public void editCliente(Cliente cliente, int linha){
//        cliente.setId((int) this.getValueAt(linha, 0));
//        ClienteController.editar(cliente);
//        listaCliente.set(linha, cliente);
//        this.fireTableRowsUpdated(linha, linha);
//    }
//
//    public boolean removeCliente(int linha) {
//       if(ClienteController.remover(this.getCliente(linha))){
//           listaCliente.remove(linha);
//           this.fireTableRowsDeleted(linha, linha);
//           return true;
//       }
//       return false;
//    }
//
//    public void refreshTabela() {
//        this.listaCliente = ClienteController.buscarTodos();
//        this.fireTableDataChanged();
//    }
//    
//    public void filterTable(String[] filters){
//       this.listaCliente = ClienteController.filtrarDado(filters);
//       this.fireTableDataChanged();
//    }
    
}
