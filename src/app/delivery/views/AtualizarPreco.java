package app.delivery.views;

import app.delivery.controller.categoria.CategoriaComboBox;
import app.delivery.controller.categoria.CategoriaController;
import app.delivery.model.beans.TipoSabor;


public class AtualizarPreco extends javax.swing.JInternalFrame {
    private final CategoriaComboBox categoriaComboBox;

    public AtualizarPreco() {
        categoriaComboBox = new CategoriaComboBox();
        initComponents();
        boxCategoria.setModel(categoriaComboBox);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        boxPreco = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoAtualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Atualizar Preço");

        boxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxCategoriaItemStateChanged(evt);
            }
        });

        jLabel1.setText("Categoria:");

        boxPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel2.setLabelFor(boxPreco);
        jLabel2.setText("Preço:");

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoAtualizarMouseReleased(evt);
            }
        });

        jLabel3.setText("em centavos.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoAtualizar)
                        .addGap(98, 98, 98)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addComponent(botaoAtualizar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxCategoriaItemStateChanged
        if (boxCategoria.getSelectedIndex() >= 0){
            boxPreco.setText(categoriaComboBox.getCusto(boxCategoria.getSelectedIndex()));
        } 
    }//GEN-LAST:event_boxCategoriaItemStateChanged

    private void botaoAtualizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAtualizarMouseReleased
         if (boxCategoria.getSelectedIndex() >= 0){
             if (boxPreco.getText().isEmpty() || boxPreco.getText().equals(0)){
                 Dialog.main("Preço inválido.");
                 return;
             }
             TipoSabor categoria = categoriaComboBox.getCategoria(boxCategoria.getSelectedIndex());
             categoria.setCusto(Double.parseDouble(boxPreco.getText())/100);
             CategoriaController.editar(categoria);
             categoriaComboBox.refresh();
         } else {
             Dialog.main("Categoria não selecionada.");
         }
    }//GEN-LAST:event_botaoAtualizarMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JComboBox<String> boxCategoria;
    private javax.swing.JFormattedTextField boxPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
