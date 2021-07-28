package app.delivery.controller.pedido;

import app.delivery.model.beans.Pedido;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PedidoTabela extends AbstractTableModel {
    private final String[] colunas = new String[]{"id", "Cliente", "Status"};
    private List<Pedido> listaPedidos;

    public PedidoTabela() {
        this.listaPedidos = PedidoController.buscarTodos();
    }
    
    @Override
    public int getRowCount() {
        return listaPedidos.size();
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
        Pedido pedido = listaPedidos.get(row);
        switch (col) {
            case 0:
                return pedido.getId();
            case 1:
                return pedido.getCliente().getNome();
            case 2:
                return pedido.getEstado().getEstado();
            default:
                return null;
        }
    }

    public Pedido getPedido(int linha) {
        return listaPedidos.get(linha);
    }

    public void refreshTabela() {
        this.listaPedidos = PedidoController.buscarTodos();
        this.fireTableDataChanged();
    }
    
}
