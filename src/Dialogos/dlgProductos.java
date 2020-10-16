/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.Dbcontext;
import Conexion.SessionHelper;
import POJOs.Producto;
import Utilidad.Mensajes;
import Utilidad.UtilTable;
import bean.ProductoBean;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel-Zamora
 */
public class dlgProductos extends javax.swing.JDialog {

    ProductoBean productoBean;
    List<Producto> productos;
    Producto producto;

    /**
     * Creates new form dlgProductos
     *
     * @param parent
     * @param modal
     */
    public dlgProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblIdProducto.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblIdProducto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lblCantidadRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Productos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><Strong>CATALOGO DE PRODUCTOS");
        jPanel3.add(jLabel7);

        jPanel6.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Información del Producto"));
        jPanel5.setPreferredSize(new java.awt.Dimension(656, 90));

        jLabel1.setText("Nombre del Producto:");

        lblIdProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdProducto.setText("Se esta editando el Registro Numero: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdProducto)
                        .addGap(217, 217, 217))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdProducto)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Filtro"));

        jTextField2.setPreferredSize(new java.awt.Dimension(300, 26));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel9.add(jTextField2);

        jPanel2.add(jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Acciones"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel10.add(btnGuardar);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel10.add(btnModificar);

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel10.add(btnCancelar);

        jPanel2.add(jPanel10);

        jPanel4.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel6.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProducto", "Nombre", "Fecha Creacion", "Usuario Creador", "Ultima Modificacion", "Usuario Modificador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblCantidadRegistros.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblCantidadRegistros.setText("Cantidad de Registros: 0");
        jPanel8.add(lblCantidadRegistros);

        jPanel7.add(jPanel8, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(683, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CargarTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Gestionar(true); //Guarda
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        FiltrarProducto(jTextField2.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (btnCancelar.getText().equals("Cancelar")) {
            UnLoadModificar();
        } else {
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            if (Utilidad.UtilTable.isAnyoneSelected(jTable1)) {
                producto = productoBean.FindById(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                LoadModificar(producto);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Gestionar(false); // Actualiza
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(dlgProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgProductos dialog = new dlgProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCantidadRegistros;
    private javax.swing.JLabel lblIdProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void CargarTabla() {
        productoBean = new ProductoBean();
        productos = productoBean.FindAll(true); // El true es para que cargue todos los productos excepto los anulados
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Utilidad.UtilTable.LimpiarTabla(modelo);
        productos.stream().forEach((p) -> {
            CargarFila(modelo, p);
        });
        lblCantidadRegistros.setText("Cantidad de Registros: " + modelo.getRowCount());
    }

    private void CargarFila(DefaultTableModel modelo, Producto p) {
        modelo.addRow(new Object[]{
            p.getIdProducto(),
            p.getNombre(),
            p.getFechaCreacion(),
            p.getUsuarioByUserCreacion().getIdUsuario(),
            p.getFechaModificacion(),
            p.getUsuarioByUserModificacion().getIdUsuario()});
    }

    private boolean VerificarCampo() {
        return txtNombre.getText().equals("");
    }

    private void LimpiarCampos() {
        txtNombre.setText("");
    }

    private boolean GuardarModificar(boolean TipoOperacion) { //True Guardar; False Modificar
        boolean Guardo = false;
        Producto p;
        if (TipoOperacion) {
            p = new Producto();
            p.setUsuarioByUserCreacion(SessionHelper.usuario);
            p.setFechaCreacion(new Date());
            p.setRegAnulado(false);
        } else {
            p = producto;
        }
        p.setUsuarioByUserModificacion(SessionHelper.usuario);
        p.setFechaModificacion(new Date());
        p.setNombre(txtNombre.getText());

        try {
            if (TipoOperacion) {
                Dbcontext.guardar(p);
            } else {
                Dbcontext.actualizar(p);
            }
            Guardo = true;
        } catch (Exception e) {
            Guardo = false;
            Mensajes.ErrorDesconocido(this, e.getMessage());
        }
        return Guardo;
    }

    private void FiltrarProducto(String text) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        UtilTable.LimpiarTabla(modelo);
        if (text.equals("")) {
            productos.stream().forEach((fila) -> {
                CargarFila(modelo, fila);
            });
        } else {
            productos.stream().forEach((fila) -> {
                if (fila.getNombre().toLowerCase().contains(text.toLowerCase())
                        || fila.getUsuarioByUserCreacion().getIdUsuario().toLowerCase().contains(text.toLowerCase())
                        || fila.getUsuarioByUserCreacion().getIdUsuario().toLowerCase().contains(text.toLowerCase())) {
                    CargarFila(modelo, fila);
                }
            });
        }
        lblCantidadRegistros.setText("Cantidad de Registros: " + modelo.getRowCount());
    }

    private void LoadModificar(Producto producto) {
        txtNombre.setText(producto.getNombre());
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnCancelar.setText("Cancelar");
        lblIdProducto.setText("<html>Se esta editando el Registro Numero: <u>" + producto.getIdProducto());
        lblIdProducto.setVisible(true);
    }

    private void Gestionar(boolean b) {
        if (VerificarCampo()) {
            Mensajes.InformacionIncompleta(this);
        } else {
            try {
                int DecisionFinal = JOptionPane.showConfirmDialog(this, (b ? Utilidad.Mensajes.CONFIRMA_INSERSION : Utilidad.Mensajes.CONFIRMA_ACTUALIZACION), "Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (DecisionFinal == 0) {
                    if (GuardarModificar(b)) {
                        Mensajes.OperacionExitosa(this);
                        CargarTabla();
                        System.out.println(dlgFacturar.FacturarActiva);
                        if (dlgFacturar.FacturarActiva) {
                            dlgFacturar.CargarProductos(dlgFacturar.OperationType);
                        }
                        UnLoadModificar();
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    private void UnLoadModificar() {
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setText("Salir");
        lblIdProducto.setVisible(false);
        LimpiarCampos();
    }

}
