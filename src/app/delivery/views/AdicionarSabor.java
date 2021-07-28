package app.delivery.views;

import app.delivery.controller.categoria.CategoriaComboBox;
import app.delivery.controller.categoria.CategoriaController;
import app.delivery.controller.pizza.SaborComboBox;
import app.delivery.model.beans.Sabor;
import app.delivery.model.beans.TipoSabor;

public class AdicionarSabor extends javax.swing.JInternalFrame {

    private final CategoriaComboBox categoriaComboBox1;
    private final CategoriaComboBox categoriaComboBox2;
    private final SaborComboBox saborComboBox1;

    public AdicionarSabor() {
        categoriaComboBox1 = new CategoriaComboBox();
        categoriaComboBox2 = new CategoriaComboBox();
        saborComboBox1 = new SaborComboBox();
        initComponents();
        categoriaComboBox.setModel(categoriaComboBox1);
        categoriaCombox2.setModel(categoriaComboBox2);
        saborComboBox.setModel(saborComboBox1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        saborBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        categoriaCombox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        saborComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox<>();
        botaoAtualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setTitle("Adicionar sabor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar"));

        jLabel4.setLabelFor(saborBox);
        jLabel4.setText("Sabor:");

        jLabel3.setLabelFor(categoriaCombox2);
        jLabel3.setText("Categoria:");

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                botaoAdicionarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saborBox, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(categoriaCombox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(botaoAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saborBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaCombox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(botaoAdicionar)
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        saborComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                saborComboBoxItemStateChanged(evt);
            }
        });

        jLabel1.setLabelFor(saborComboBox);
        jLabel1.setText("Sabor:");

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                botaoAtualizarKeyReleased(evt);
            }
        });

        jLabel5.setLabelFor(categoriaComboBox);
        jLabel5.setText("Categoria:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(botaoAtualizar)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saborComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saborComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoAtualizar)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saborComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_saborComboBoxItemStateChanged
        if(saborComboBox.getSelectedIndex() >= 0){
            categoriaComboBox1.setCategoria(saborComboBox1.getSabor(saborComboBox.getSelectedIndex()).getTipo().getNome());
        }
    }//GEN-LAST:event_saborComboBoxItemStateChanged

    private void botaoAtualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoAtualizarKeyReleased
        if(saborComboBox.getSelectedIndex() >= 0 && categoriaComboBox.getSelectedIndex() >= 0){
            TipoSabor categoria = categoriaComboBox1.getCategoria(categoriaComboBox.getSelectedIndex());
            CategoriaController.editar(categoria);
        } else {
            Dialog.main("Valores não selecionados");
        }
    }//GEN-LAST:event_botaoAtualizarKeyReleased

    private void botaoAdicionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoAdicionarKeyReleased
        if(categoriaCombox2.getSelectedIndex() >= 0 && saborBox.getText().length() > 0){
            TipoSabor categoria = categoriaComboBox2.getCategoria(categoriaCombox2.getSelectedIndex());
            Sabor sabor = new Sabor();
            sabor.setNome(saborBox.getText());
            sabor.setTipo(categoria);
            CategoriaController.adicionar(sabor);
            saborComboBox1.refresh();
        } else {
            Dialog.main("Valores não selecionados");
        }
    }//GEN-LAST:event_botaoAdicionarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JComboBox<String> categoriaCombox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField saborBox;
    private javax.swing.JComboBox<String> saborComboBox;
    // End of variables declaration//GEN-END:variables
}
