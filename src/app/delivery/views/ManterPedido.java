package app.delivery.views;

import app.delivery.controller.cliente.ClienteComboBox;
import app.delivery.controller.pedido.PedidoController;
import app.delivery.controller.pedido.PedidoList;
import app.delivery.controller.pizza.PizzaController;
import app.delivery.controller.pizza.PizzaTabela;
import app.delivery.controller.pizza.SaborComboBox;
import app.delivery.model.beans.Cliente;
import app.delivery.model.beans.Pedido;
import app.delivery.model.beans.Pizza;
import app.delivery.model.beans.Sabor;
import app.delivery.model.beans.formatos.Circulo;
import app.delivery.model.beans.formatos.FormatoAbstract;
import app.delivery.model.beans.formatos.Formatos;
import app.delivery.model.beans.formatos.Quadrado;
import app.delivery.model.beans.formatos.Triangulo;
import app.exceptions.TamanhoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ManterPedido extends javax.swing.JInternalFrame {

    private List<Cliente> listaClientes;
    private final ClienteComboBox clienteComboBox;
    private final SaborComboBox saborComboBox1;
    private final SaborComboBox saborComboBox2;
    private final PedidoList pedidoList;
    private final PizzaTabela pizzaTabela;

    public ManterPedido() {
        this.saborComboBox1 = new SaborComboBox();
        this.saborComboBox2 = new SaborComboBox();
        this.pedidoList = new PedidoList();
        this.pizzaTabela = new PizzaTabela();
        initComponents();
        clienteComboBox = new ClienteComboBox();
        boxCliente.setModel(clienteComboBox);
        boxSabor1.setModel(saborComboBox1);
        boxSabor2.setModel(saborComboBox2);
        boxPedidos.setModel(pedidoList);
        TabelaPizzas.getColumnModel().getColumn(0).setPreferredWidth(15);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        filterTelefone = new javax.swing.JFormattedTextField();
        boxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        boxFormato = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxTamanho = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxSabor1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        boxSabor2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        boxArea = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        checkTamanho = new javax.swing.JCheckBox();
        checkArea = new javax.swing.JCheckBox();
        checkSabor2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        boxPreco = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaPizzas = new javax.swing.JTable();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        linhaAtual = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        boxPedidos = new javax.swing.JList<>();
        botaoRemover = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manter Pedido");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        try {
            filterTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**) * ****-****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        filterTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTelefoneKeyPressed(evt);
            }
        });

        boxCliente.setSelectedItem(null);
        boxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxClienteItemStateChanged(evt);
            }
        });

        jLabel1.setText("Cliente:");

        jLabel2.setText("Telefone:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        boxFormato.setModel(new DefaultComboBoxModel(app.delivery.model.beans.formatos.Formatos.values()));
        boxFormato.setSelectedItem(null);

        jLabel3.setText("Formato:");

        boxTamanho.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxTamanho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxTamanhoKeyReleased(evt);
            }
        });

        jLabel4.setText("cm");

        jLabel5.setText("Tamanho:");

        jLabel6.setText("Sabor 1:");

        boxSabor2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxSabor2ItemStateChanged(evt);
            }
        });

        jLabel7.setText("Sabor 2:");

        boxArea.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxAreaKeyReleased(evt);
            }
        });

        jLabel8.setText("cm²");

        jLabel9.setText("Área:");

        checkTamanho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkTamanhoItemStateChanged(evt);
            }
        });

        checkArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkAreaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxSabor2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxSabor1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(boxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(boxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(boxFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkTamanho)
                    .addComponent(checkArea)
                    .addComponent(checkSabor2))
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(checkTamanho)
                            .addComponent(boxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(checkArea)
                            .addComponent(boxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxSabor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(checkSabor2)
                            .addComponent(boxSabor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel4)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel10.setText("O valor total é: ");

        boxPreco.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Pedidos:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Itens inclusos no pedido:");

        TabelaPizzas.setModel(pizzaTabela);
        TabelaPizzas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TabelaPizzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelaPizzasMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaPizzas);

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoAdicionarMouseReleased(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoEditarMouseReleased(evt);
            }
        });

        linhaAtual.setFocusable(false);

        boxPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        boxPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boxPedidosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(boxPedidos);

        botaoRemover.setText("Remover");
        botaoRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoRemoverMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(linhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(boxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(linhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(botaoEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoRemover))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(botaoAdicionar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(boxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTelefoneKeyPressed
        clienteComboBox.filterElements(filterTelefone.getText());
    }//GEN-LAST:event_filterTelefoneKeyPressed

    private void checkTamanhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkTamanhoItemStateChanged
        if (checkTamanho.isSelected() && checkArea.isSelected()) {
            checkArea.setSelected(false);
            boxArea.setText("");
        }
    }//GEN-LAST:event_checkTamanhoItemStateChanged

    private void checkAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkAreaItemStateChanged
        if (checkArea.isSelected() && checkTamanho.isSelected()) {
            checkTamanho.setSelected(false);
            boxTamanho.setText("");
        }
    }//GEN-LAST:event_checkAreaItemStateChanged

    private void boxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxClienteItemStateChanged
        pizzaTabela.refreshTabela(-1);
        linhaAtual.setText("");
        if (boxCliente.getSelectedIndex() > -1) {
            pedidoList.filterCliente(clienteComboBox.getCliente(boxCliente.getSelectedIndex()));
        }
    }//GEN-LAST:event_boxClienteItemStateChanged

    private void boxPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxPedidosMousePressed
        pizzaTabela.refreshTabela(pedidoList.getPedidoId(boxPedidos.getSelectedIndex()));
        boxPreco.setText(pizzaTabela.getValorTotal());
        linhaAtual.setText("");
    }//GEN-LAST:event_boxPedidosMousePressed

    private void TabelaPizzasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaPizzasMousePressed
        if (TabelaPizzas.getSelectedRow() >= 0) {
            Pizza pizza = pizzaTabela.getPizza(TabelaPizzas.getSelectedRow());
            if (pizza.getFormato() instanceof Circulo) {
                boxFormato.setSelectedItem(Formatos.CIRCULO);
            }
            if (pizza.getFormato() instanceof Quadrado) {
                boxFormato.setSelectedItem(Formatos.QUADRADO);
            }
            if (pizza.getFormato() instanceof Triangulo) {
                boxFormato.setSelectedItem(Formatos.TRIANGULO);
            }
            boxTamanho.setText(String.valueOf((int) pizza.getFormato().getDimension()));
            boxArea.setText("");
            checkArea.setSelected(false);
            checkTamanho.setSelected(true);
            saborComboBox1.selecionarSabor(pizza.getSabores().get(0));
            if (pizza.getSaboresSize() > 1) {
                saborComboBox2.selecionarSabor(pizza.getSabores().get(1));
                checkSabor2.setSelected(true);
            } else {
                checkSabor2.setSelected(false);
                saborComboBox2.setSelectedItem(null);
            }
            linhaAtual.setText(String.valueOf(TabelaPizzas.getSelectedRow()));
        }
    }//GEN-LAST:event_TabelaPizzasMousePressed

    private void botaoAdicionarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAdicionarMouseReleased
        if (!checkFields()) {
            return;
        }
        Pizza pizza = this.getPizza();
        if (pizza == null) {
            Dialog.main("Seleções inválidas!");
            return;
        }
        Pedido pedido;
        if (boxPedidos.getSelectedIndex() == 0) {
            pedido = new Pedido();
            pedido.setId(-1);
        } else {
            pedido = pedidoList.getPedido(boxPedidos.getSelectedIndex());
        }
        pedido.setTotal(pizzaTabela.getValorTotalNumeric());
        Cliente cliente = clienteComboBox.getCliente(boxCliente.getSelectedIndex());
        pedido.setCliente(cliente);
        pizza.setId(-1);
        PizzaController.adicionar(pizza, pedido);
        if (boxPedidos.getSelectedIndex() == 0) {
            pedidoList.filterCliente(cliente);
            boxPedidos.setSelectedIndex(pedidoList.getSize() - 1);
            pizzaTabela.refreshTabela(pedidoList.getPedidoId(boxPedidos.getSelectedIndex()));
            boxPreco.setText(pizzaTabela.getValorTotal());
        } else {
            pizzaTabela.refreshTabela(pedidoList.getPedidoId(boxPedidos.getSelectedIndex()));
            boxPreco.setText(pizzaTabela.getValorTotal());
        }
    }//GEN-LAST:event_botaoAdicionarMouseReleased

    private void botaoEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEditarMouseReleased
        if (!checkFields()) {
            return;
        }
        if (TabelaPizzas.getSelectedRow() >= 0) {
            Pizza pizza = getPizza();
            if (pizza == null) {
                Dialog.main("Seleções inválidas!");
                return;
            }
            pizza.getFormato().setId(pizzaTabela.getPizza(TabelaPizzas.getSelectedRow()).getFormato().getId());
            PizzaController.editar(pizza);

            Pedido pedido = new Pedido();
            pedido.setId(pedidoList.getPedidoId(boxPedidos.getSelectedIndex()));

            pizzaTabela.refreshTabela(pedidoList.getPedidoId(boxPedidos.getSelectedIndex()));
            pedido.setTotal(pizzaTabela.getValorTotalNumeric());
            PedidoController.editar(pedido);
            boxPreco.setText(pizzaTabela.getValorTotal());
        } else {
            Dialog.main("Nenhuma linha na tabela selecionada!");
        }
    }//GEN-LAST:event_botaoEditarMouseReleased

    private void botaoRemoverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoRemoverMouseReleased
        if (TabelaPizzas.getSelectedRow() >= 0) {
            int linha = TabelaPizzas.getSelectedRow();
            Object[] opcoes = {"Sim", "Não"};
            Object defaultChoice = opcoes[1];
            int input = JOptionPane.showOptionDialog(null,
                    "Tem certeza que deseja remover o cliente selecionado?",
                    "Atenção!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    defaultChoice);
            if (input == 0) {
                Pizza pizza = pizzaTabela.getPizza(linha);
                PizzaController.remover(pizza);
                pizzaTabela.removePizza(linha);
                boxPreco.setText(pizzaTabela.getValorTotal());
                linhaAtual.setText("");
            }
        } else {
            Dialog.main("Nenhuma linha na tabela selecionada!");
        }
    }//GEN-LAST:event_botaoRemoverMouseReleased

    private void boxSabor2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxSabor2ItemStateChanged
        if (boxSabor2.getSelectedIndex() >= 0) {
            checkSabor2.setSelected(true);
        }
    }//GEN-LAST:event_boxSabor2ItemStateChanged

    private void boxTamanhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxTamanhoKeyReleased
        checkTamanho.setSelected(true);
        checkArea.setSelected(false);
        boxArea.setText("");
    }//GEN-LAST:event_boxTamanhoKeyReleased

    private void boxAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxAreaKeyReleased
        checkTamanho.setSelected(false);
        checkArea.setSelected(true);
        boxTamanho.setText("");
    }//GEN-LAST:event_boxAreaKeyReleased

    private Pizza getPizza() {
        if (!checkFields()) {
            return null;
        }
        Pizza pizza = new Pizza();
        FormatoAbstract forma;
        if (boxFormato.getSelectedItem() == Formatos.CIRCULO) {
            forma = new Circulo();
        } else if (boxFormato.getSelectedItem() == Formatos.QUADRADO) {
            forma = new Quadrado();
        } else {
            forma = new Triangulo();
        }

        try {
            if (checkArea.isSelected()) {
                forma.setArea(Double.parseDouble(boxArea.getText()));
            } else {
                forma.setDimension(Double.parseDouble(boxTamanho.getText()));
            }
        } catch (TamanhoException e) {
            Dialog.main("O tamanho inserido é superior ao limite definido.");
            return null;
        }
        pizza.setFormato(forma);
        List<Sabor> sabores = new ArrayList<>();
        sabores.add(saborComboBox1.getSabor(boxSabor1.getSelectedIndex()));
        if (checkSabor2.isSelected()) {
            sabores.add(saborComboBox2.getSabor(boxSabor2.getSelectedIndex()));
        }

        pizza.setSabores(sabores);
        if (TabelaPizzas.getSelectedRow() >= 0) {
            pizza.setId(pizzaTabela.getPizza(TabelaPizzas.getSelectedRow()).getId());
        }

        return pizza;
    }

    private boolean checkFields() {
        if (boxArea.getText().isEmpty() && boxTamanho.getText().isEmpty()) {
            Dialog.main("Nenhuma dimensão inserida.");
            return false;
        }

        if (boxCliente.getSelectedIndex() < 0) {
            Dialog.main("Cliente não selecionado.");
            return false;
        }

        if (boxFormato.getSelectedIndex() < 0) {
            Dialog.main("Formato não selecionado.");
            return false;
        }

        if (boxSabor1.getSelectedIndex() < 0 || (boxSabor2.getSelectedIndex() < 0 && checkSabor2.isSelected())) {
            Dialog.main("Sabores não selecionados corretamente.");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaPizzas;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JFormattedTextField boxArea;
    private javax.swing.JComboBox<String> boxCliente;
    private javax.swing.JComboBox<String> boxFormato;
    private javax.swing.JList<String> boxPedidos;
    private javax.swing.JButton boxPreco;
    private javax.swing.JComboBox<String> boxSabor1;
    private javax.swing.JComboBox<String> boxSabor2;
    private javax.swing.JFormattedTextField boxTamanho;
    private javax.swing.JCheckBox checkArea;
    private javax.swing.JCheckBox checkSabor2;
    private javax.swing.JCheckBox checkTamanho;
    private javax.swing.JFormattedTextField filterTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton linhaAtual;
    // End of variables declaration//GEN-END:variables
}
