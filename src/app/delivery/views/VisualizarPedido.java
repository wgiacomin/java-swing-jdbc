package app.delivery.views;

import app.delivery.controller.pedido.EstadoComboBox;
import app.delivery.controller.pedido.PedidoController;
import app.delivery.controller.pedido.PedidoTabela;
import app.delivery.model.beans.Pedido;

public class VisualizarPedido extends javax.swing.JInternalFrame {

    private final PedidoTabela pedidosTabela = new PedidoTabela();
    EstadoComboBox estadobox;

    public VisualizarPedido() {
        estadobox = new EstadoComboBox();
        initComponents();
        TabelaPedidos.getColumnModel().getColumn(0).setPreferredWidth(15);
        boxEstados.setModel(estadobox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        boxEstados = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        botaoAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Visualizar pedidos");

        TabelaPedidos.setModel(pedidosTabela);
        TabelaPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TabelaPedidos);

        jLabel1.setText("Alterar status:");

        botaoAlterar.setText("Alterar");
        botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botaoAlterarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(botaoAlterar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(botaoAlterar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAlterarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAlterarMousePressed
       if (TabelaPedidos.getSelectedRow() >= 0 && boxEstados.getSelectedIndex() >= 0){
           int linha = TabelaPedidos.getSelectedRow();
           Pedido pedido = pedidosTabela.getPedido(linha);
           pedido.setEstado(estadobox.getEstado(boxEstados.getSelectedIndex()));
           PedidoController.editarStatus(pedido);
           pedidosTabela.refreshTabela();
           TabelaPedidos.setRowSelectionInterval(linha, linha);
       } else {
           Dialog.main("Linha não selecionada");
       }
    }//GEN-LAST:event_botaoAlterarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JComboBox<String> boxEstados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
