package app.delivery.controller.pedido;

import app.delivery.model.beans.estado.Estado;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class EstadoComboBox extends DefaultComboBoxModel<String> {

    List<Estado> listaEstados;

    public EstadoComboBox() {
        listaEstados = PedidoController.buscarTodosEstados();
        refreshData();
        this.setSelectedItem(null);
    }

    private void refreshData() {
        listaEstados.forEach(e -> {
            this.addElement(e.getEstado());
        });
    }
    
    public Estado getEstado(int index){
        return listaEstados.get(index);
    }
}
