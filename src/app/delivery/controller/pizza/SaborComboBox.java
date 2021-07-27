package app.delivery.controller.pizza;

import app.delivery.model.beans.Sabor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class SaborComboBox extends DefaultComboBoxModel<String> {

    List<Sabor> listaSabores;

    public SaborComboBox() {
        listaSabores = SaborController.buscarTodos();
        listaSabores.forEach(e -> {
            this.addElement(e.getNome());
        });
        this.setSelectedItem(null);
    }

}
