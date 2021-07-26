/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.delivery.views.cliente;

import app.delivery.controller.cliente.ClienteTabela;
import app.delivery.model.beans.Cliente;

public class ManterCliente extends javax.swing.JInternalFrame {

    private int linhaAtual_ = -1;
    private ClienteTabela clientesTabela = new ClienteTabela();
    private String[] filters;

    public ManterCliente() {
        this.filters = new String[]{"", "", ""};
        initComponents();
        TabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(15);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        boxNome = new javax.swing.JTextField();
        boxSobrenome = new javax.swing.JTextField();
        boxTelefone = new javax.swing.JFormattedTextField();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        filtrarNome = new javax.swing.JTextField();
        filtrarSobrenome = new javax.swing.JTextField();
        checkSobrenome = new javax.swing.JCheckBox();
        checkTelefone = new javax.swing.JCheckBox();
        checkNome = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filtrarTelefone = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        linhaAtual = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manter Cliente");

        TabelaClientes.setModel(clientesTabela);
        TabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelaClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaClientes);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar/Editar"));

        boxNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxNomeKeyReleased(evt);
            }
        });

        boxSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxSobrenomeKeyReleased(evt);
            }
        });

        try {
            boxTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        botaoAdicionar.setText("Adicionar");

        botaoEditar.setText("Editar");

        botaoRemover.setText("Remover");

        jLabel1.setLabelFor(boxNome);
        jLabel1.setText("Nome:");

        jLabel2.setLabelFor(boxSobrenome);
        jLabel2.setText("Sobrenome:");

        jLabel3.setLabelFor(boxTelefone);
        jLabel3.setText("Telefone:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxNome)
                            .addComponent(boxSobrenome)
                            .addComponent(boxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoEditar))
                .addGap(28, 28, 28)
                .addComponent(botaoRemover)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        filtrarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarNomeKeyReleased(evt);
            }
        });

        filtrarSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarSobrenomeKeyReleased(evt);
            }
        });

        checkSobrenome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkSobrenomeItemStateChanged(evt);
            }
        });

        checkTelefone.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkTelefoneItemStateChanged(evt);
            }
        });

        checkNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkNomeItemStateChanged(evt);
            }
        });

        jLabel4.setLabelFor(filtrarNome);
        jLabel4.setText("Nome:");

        jLabel5.setLabelFor(filtrarSobrenome);
        jLabel5.setText("Sobrenome:");

        jLabel6.setLabelFor(filtrarTelefone);
        jLabel6.setText("Telefone:");

        try {
            filtrarTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        filtrarTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarTelefoneKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtrarSobrenome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filtrarNome)
                    .addComponent(filtrarTelefone))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(checkSobrenome)
                        .addComponent(checkTelefone, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(checkNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filtrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(checkNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filtrarSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(checkSobrenome))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(checkTelefone)
                    .addComponent(filtrarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel7.setText("A linha selecionada é a ");

        linhaAtual.setFocusPainted(false);
        linhaAtual.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(linhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxNomeKeyReleased
        boxNome.setText(boxNome.getText().replaceAll("[^a-zA-Z]", ""));
    }//GEN-LAST:event_boxNomeKeyReleased

    private void boxSobrenomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxSobrenomeKeyReleased
        boxSobrenome.setText(boxSobrenome.getText().replaceAll("[^a-zA-Z ]", ""));
    }//GEN-LAST:event_boxSobrenomeKeyReleased

    private void checkNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkNomeItemStateChanged
        if (checkNome.isSelected()) {
            filters[0] = filtrarNome.getText();
        } else {
            filters[0] = "";
        }
        this.clientesTabela.filterTable(filters);
    }//GEN-LAST:event_checkNomeItemStateChanged

    private void checkSobrenomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkSobrenomeItemStateChanged
        if (checkNome.isSelected()) {
            filters[1] = filtrarSobrenome.getText();
        } else {
            filters[1] = "";
        }
        this.clientesTabela.filterTable(filters);
    }//GEN-LAST:event_checkSobrenomeItemStateChanged

    private void checkTelefoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkTelefoneItemStateChanged
        if (checkNome.isSelected()) {
            filters[2] = filtrarTelefone.getText();
        } else {
            filters[2] = "";
        }
        this.clientesTabela.filterTable(filters);
    }//GEN-LAST:event_checkTelefoneItemStateChanged

    private void filtrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarNomeKeyReleased
        if (!checkNome.isSelected()) {
            checkNome.setSelected(true);
        } else {
            filters[0] = filtrarNome.getText();
            this.clientesTabela.filterTable(filters);
        }
    }//GEN-LAST:event_filtrarNomeKeyReleased

    private void filtrarSobrenomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarSobrenomeKeyReleased
        if (!checkSobrenome.isSelected()) {
            checkSobrenome.setSelected(true);
        } else {
            filters[1] = filtrarSobrenome.getText();
            this.clientesTabela.filterTable(filters);
        }
    }//GEN-LAST:event_filtrarSobrenomeKeyReleased

    private void filtrarTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtrarTelefoneKeyReleased
        if (!checkTelefone.isSelected()) {
            checkTelefone.setSelected(true);
        } else {
            filters[2] = filtrarTelefone.getText();
            this.clientesTabela.filterTable(filters);
        }
    }//GEN-LAST:event_filtrarTelefoneKeyReleased

    private void TabelaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClientesMousePressed
        linhaAtual_ = TabelaClientes.rowAtPoint(evt.getPoint());
        if (linhaAtual_ != -1) {
            Cliente cliente = clientesTabela.getCliente(linhaAtual_);
            linhaAtual.setText(String.valueOf(cliente.getId()));
            boxNome.setText(cliente.getNome());
            boxSobrenome.setText(cliente.getSobrenome());
            boxTelefone.setText(cliente.getTelefone());
        }
    }//GEN-LAST:event_TabelaClientesMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JTextField boxNome;
    private javax.swing.JTextField boxSobrenome;
    private javax.swing.JFormattedTextField boxTelefone;
    private javax.swing.JCheckBox checkNome;
    private javax.swing.JCheckBox checkSobrenome;
    private javax.swing.JCheckBox checkTelefone;
    private javax.swing.JTextField filtrarNome;
    private javax.swing.JTextField filtrarSobrenome;
    private javax.swing.JFormattedTextField filtrarTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton linhaAtual;
    // End of variables declaration//GEN-END:variables
}
