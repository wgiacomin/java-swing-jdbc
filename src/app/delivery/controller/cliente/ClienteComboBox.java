package app.delivery.controller.cliente;

import app.delivery.model.beans.Cliente;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class ClienteComboBox extends DefaultComboBoxModel<String> {

    List<Cliente> listaClientes;

    public ClienteComboBox() {
        listaClientes = ClienteController.buscarTodos();
        refreshData();
    }

    public void filterElements(String telefone) {
        listaClientes = ClienteController.filtrarDado(new String[]{"", "", telefone});
        this.removeAllElements();
        this.refreshData();
    }

    private void refreshData() {
        listaClientes.forEach(e -> {
            this.addElement(e.getNome());
        });
        this.setSelectedItem(null);
    }
}
