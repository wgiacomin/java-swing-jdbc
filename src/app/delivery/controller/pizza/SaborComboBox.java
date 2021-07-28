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

    public void selecionarSabor(Sabor sabor) {
        if (sabor == null) {
            this.setSelectedItem(null);
            return;
        }
        for (int i = 0; i < this.getSize(); i++){
            if (this.getElementAt(i).equals(sabor.getNome())){
                this.setSelectedItem(this.getElementAt(i));
                return;
            }
        }
    }
    
    public Sabor getSabor(int index){
        if (index >= 0){
            return listaSabores.get(index);
        }
        return null;
    }
    
    
    public void refresh() {
        this.removeAllElements();
        listaSabores = SaborController.buscarTodos();
        listaSabores.forEach(e -> {
            this.addElement(e.getNome());
        });
        this.setSelectedItem(null);
    }
}
