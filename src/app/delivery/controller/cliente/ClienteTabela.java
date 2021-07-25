package app.delivery.controller.cliente;

import app.delivery.model.beans.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTabela extends AbstractTableModel {
    private final String[] colunas = new String[]{"id", "Nome", "Sobrenome", "Telefone"};
    private List<Cliente> listaCliente;

    public ClienteTabela() {
        this.listaCliente = ClienteController.buscarTodos();
    }
    
    @Override
    public int getRowCount() {
        return listaCliente.size();
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
        Cliente cliente = listaCliente.get(row);
        switch (col) {
            case 0:
                return cliente.getId();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getSobrenome();
            case 3:
                return cliente.getTelefone();
            default:
                return null;
        }
    }

    public Cliente getCliente(int linha) {
        return listaCliente.get(linha);
    }

    public void addCliente(Cliente cliente) {
        
    }

    public boolean removeCliente(int linha) {
        return true;
    }

    public void refreshTabela(List<Cliente> lista) {
        this.fireTableDataChanged();
    }
}
