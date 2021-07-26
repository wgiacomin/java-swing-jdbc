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
        ClienteController.adicionar(cliente);
        listaCliente.add(cliente);
        this.fireTableRowsInserted(this.listaCliente.size() -1, this.listaCliente.size() -1);
    }
    
    public void editCliente(Cliente cliente, int linha){
        cliente.setId((int) this.getValueAt(linha, 0));
        ClienteController.editar(cliente);
        listaCliente.set(linha, cliente);
        this.fireTableRowsUpdated(linha, linha);
    }

    public boolean removeCliente(int linha) {
       if(ClienteController.remover(this.getCliente(linha))){
           listaCliente.remove(linha);
           this.fireTableRowsDeleted(linha, linha);
           return true;
       }
       return false;
    }

    public void refreshTabela() {
        this.listaCliente = ClienteController.buscarTodos();
        this.fireTableDataChanged();
    }
    
    public void filterTable(String[] filters){
       this.listaCliente = ClienteController.filtrarDado(filters);
       this.fireTableDataChanged();
    }
}
