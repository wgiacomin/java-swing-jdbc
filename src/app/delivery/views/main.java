package app.delivery.views;

import app.delivery.model.dao.utils.ConnectionFactory;
import app.delivery.views.ManterCliente;
import app.delivery.views.ManterPedido;
import app.exceptions.DAOException;
import java.awt.Dimension;

public class main extends javax.swing.JFrame {

    public main() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        try (ConnectionFactory factory = new ConnectionFactory()) {
            factory.getConnection();
        } catch (DAOException e) {
            Dialog.main("Sem acesso ao banco! O aplicativo pode apresentar comportamento inesperado.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        mainScreen = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        manterPedido = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        precosCm = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizza Delivery");

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );

        jMenu2.setText("Cliente");

        menuCadastrar.setText("Cadastrar");
        menuCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                menuCadastrarMouseReleased(evt);
            }
        });
        jMenu2.add(menuCadastrar);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Pedidos");

        manterPedido.setText("Manter");
        manterPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                manterPedidoMouseReleased(evt);
            }
        });
        jMenu1.add(manterPedido);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pizzas");

        precosCm.setText("Preços por cm²");
        precosCm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                precosCmMouseReleased(evt);
            }
        });
        jMenu3.add(precosCm);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScreen)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScreen)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastrarMouseReleased
        ManterCliente manterCliente = new ManterCliente();
        this.mainScreen.add(manterCliente);
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = manterCliente.getSize();
        manterCliente.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height - 100) / 2);
        manterCliente.setVisible(true);
    }//GEN-LAST:event_menuCadastrarMouseReleased

    private void manterPedidoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manterPedidoMouseReleased
        ManterPedido manterPedido = new ManterPedido();
        this.mainScreen.add(manterPedido);
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = manterPedido.getSize();
        manterPedido.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height - 100) / 2);
        manterPedido.setVisible(true);
    }//GEN-LAST:event_manterPedidoMouseReleased

    private void precosCmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precosCmMouseReleased
        AtualizarPreco atualizarPreco = new AtualizarPreco();
        this.mainScreen.add(atualizarPreco);
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = atualizarPreco.getSize();
        atualizarPreco.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height - 100) / 2);
        atualizarPreco.setVisible(true);
    }//GEN-LAST:event_precosCmMouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane mainScreen;
    private javax.swing.JMenuItem manterPedido;
    private javax.swing.JMenuItem menuCadastrar;
    private javax.swing.JMenuItem precosCm;
    // End of variables declaration//GEN-END:variables
}
