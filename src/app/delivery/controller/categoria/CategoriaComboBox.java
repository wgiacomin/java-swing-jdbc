package app.delivery.controller.categoria;

import app.delivery.model.beans.TipoSabor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class CategoriaComboBox extends DefaultComboBoxModel<String> {

    List<TipoSabor> listaCategoria;

    public CategoriaComboBox() {
        listaCategoria = CategoriaController.buscarTodos();
        listaCategoria.forEach(e -> {
            this.addElement(e.getNome());
        });
        this.setSelectedItem(null);
    }

    public String getCusto(int index) {
        return String.valueOf((int) (listaCategoria.get(index).getCusto() * 100));
    }

    public void refresh() {
        listaCategoria = CategoriaController.buscarTodos();
    }

    public TipoSabor getCategoria(int index) {
        return listaCategoria.get(index);
    }

    public void setCategoria(String categoria) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getElementAt(i).equals(categoria)) {
                this.setSelectedItem(this.getElementAt(i));
            }
        }
    }
}
