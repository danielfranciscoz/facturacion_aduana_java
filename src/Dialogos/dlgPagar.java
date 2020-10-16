/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.Dbcontext;
import Conexion.SessionHelper;
import InternalFrames.ifrEstadoCuentas;
import InternalFrames.ifrRegistroFacturas;
import POJOs.Cliente;
import POJOs.Detallenotadebito;
import POJOs.Detallerecibo;
import POJOs.Factura;
import POJOs.Notadebito;
import POJOs.Recibo;
import POJOs.Serviciosagencia;
import Utilidad.JTextValid;
import Utilidad.Mensajes;
import Utilidad.UtilTable;
import Utilidad.Validador;
import bean.ClienteBean;
import bean.DetalleNotaDebitoBean;
import bean.DetalleReciboBean;
import bean.FacturasBean;
import bean.NotaDebitoBean;
import bean.ReciboBean;
import bean.ServicioAgenciaBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Daniel-Zamora
 */
public class dlgPagar extends javax.swing.JDialog {

    ClienteBean clientesBean;
    List<Cliente> clientes;
    Cliente cliente;

    FacturasBean facturasBean;
    List<Factura> facturas;

    ServicioAgenciaBean servicioAgenciaBean;
    List<ServicioAgenciaBean> serviciosAgencia;

    NotaDebitoBean notaDebitoBean;
    List<Notadebito> notasDebito;

    DetalleNotaDebitoBean debitoBean;
    List<Detallenotadebito> detalleNotaDebitos;

    ReciboBean reciboBean;
    List<Recibo> recibos;
    Recibo recibo;

    DetalleReciboBean detalleReciboBean;
    List<Detallerecibo> detalleRecibosTemp;

    double Total;

    private int IdCliente;
    private int IdRecibo;

    /*
    QUEDA PENDIENTE TODA LA FUNCIONALIDAD DE ESTA PANTALLA
     */
    /**
     * Creates new form dlgEstadosCuenta
     *
     * @param parent
     * @param modal
     * @param IdCliente
     */
    public dlgPagar(java.awt.Frame parent, boolean modal, int IdCliente) {
        super(parent, modal);
        this.IdCliente = IdCliente;
        clientesBean = new ClienteBean();
        facturasBean = new FacturasBean();
        servicioAgenciaBean = new ServicioAgenciaBean();
        notaDebitoBean = new NotaDebitoBean();
        debitoBean = new DetalleNotaDebitoBean();
        reciboBean = new ReciboBean();
        detalleReciboBean = new DetalleReciboBean();
        initComponents();
        InicializarEncabezado();
        try {
            PromptSupport.setPrompt("" + reciboBean.NoReciboConsecutivo(), txtNumeroRecibo);
        } catch (NullPointerException e) {
            PromptSupport.setPrompt("1", txtNumeroRecibo);
        }

        tblDeudas.getSelectionModel()
                .addListSelectionListener((ListSelectionEvent e) -> {
                    jTable1SelectionChanged(e);
                }
                );

        IniciarValidator();

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
        jPanel21 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeudas = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMontoPagar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblMontoRecibo = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtNumeroRecibo = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        txtMontoFisico = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtIMI = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txtIR = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("<html><Strong>CREACIÓN DE RECIBOS OFICIALES DE CAJA");
        jPanel21.add(lblTitulo);

        jPanel1.add(jPanel21, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Deudas del Cliente"));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 467));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tblDeudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Deuda", "# de Registro", "Saldo Deudor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeudas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDeudas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDeudas);
        tblDeudas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setText("Monto a Pagar: C$");
        jPanel15.add(jLabel1);

        txtMontoPagar.setMinimumSize(new java.awt.Dimension(150, 20));
        txtMontoPagar.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel15.add(txtMontoPagar);

        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton3);

        jPanel7.add(jPanel15, java.awt.BorderLayout.SOUTH);

        jPanel5.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Registros a Pagar"));
        jPanel8.setPreferredSize(new java.awt.Dimension(400, 467));
        jPanel8.setLayout(new java.awt.BorderLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Deuda", "# de Registro", "Monto a Pagar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblPagos.setColumnSelectionAllowed(true);
        tblPagos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPagos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPagos);
        tblPagos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton2.setText("<<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton2);

        jPanel8.add(jPanel16, java.awt.BorderLayout.SOUTH);

        jPanel5.add(jPanel8);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel10.setLayout(new java.awt.BorderLayout());

        lblMontoRecibo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblMontoRecibo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoRecibo.setText("<html><Strong>Monto del Recibo: C$ 0.00");
        jPanel10.add(lblMontoRecibo, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel10);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("No. Recibo:");
        jPanel20.add(jLabel5, java.awt.BorderLayout.WEST);

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        txtNumeroRecibo.setMaximumSize(new java.awt.Dimension(150, 26));
        txtNumeroRecibo.setMinimumSize(new java.awt.Dimension(150, 26));
        txtNumeroRecibo.setPreferredSize(new java.awt.Dimension(190, 26));
        txtNumeroRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroReciboActionPerformed(evt);
            }
        });
        jPanel22.add(txtNumeroRecibo);

        jPanel20.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel20);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Monto del Recibo Fisico:");
        jPanel12.add(jLabel2, java.awt.BorderLayout.WEST);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        txtMontoFisico.setMaximumSize(new java.awt.Dimension(150, 26));
        txtMontoFisico.setMinimumSize(new java.awt.Dimension(150, 26));
        txtMontoFisico.setPreferredSize(new java.awt.Dimension(190, 26));
        txtMontoFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoFisicoActionPerformed(evt);
            }
        });
        jPanel19.add(txtMontoFisico);

        jPanel12.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("IMI (1%):");
        jPanel13.add(jLabel3, java.awt.BorderLayout.WEST);

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        txtIMI.setMaximumSize(new java.awt.Dimension(150, 26));
        txtIMI.setMinimumSize(new java.awt.Dimension(150, 26));
        txtIMI.setPreferredSize(new java.awt.Dimension(190, 26));
        txtIMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIMIActionPerformed(evt);
            }
        });
        jPanel18.add(txtIMI);

        jPanel13.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel13);

        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("IR (2%):");
        jPanel14.add(jLabel4, java.awt.BorderLayout.WEST);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        txtIR.setMaximumSize(new java.awt.Dimension(150, 26));
        txtIR.setMinimumSize(new java.awt.Dimension(150, 26));
        txtIR.setPreferredSize(new java.awt.Dimension(190, 26));
        txtIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIRActionPerformed(evt);
            }
        });
        jPanel17.add(txtIR);

        jPanel14.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel14);

        jPanel4.add(jPanel11);

        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel9.add(btnGuardar);

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton5);

        jPanel6.add(jPanel9);

        getContentPane().add(jPanel6, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(707, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CargarDeudasCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (UtilTable.isAnyoneSelected(tblDeudas)) {
            if (!txtMontoPagar.getText().equals("")) {
                if (Double.parseDouble(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 2).toString().replaceAll(",", "")) != 0) {
                    VerificarMontos();
                } else {
                    Mensajes.ErrorMessage(this, "Error al Agregar Registro", "El registro seleccionado se encuentra con saldo 0.00, seleecione un registro que posea saldos mayores a 0.00");
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (UtilTable.isAnyoneSelected(tblPagos)) {
            RetornarMonto();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNumeroRecibo.getText().equals("")) {
            Mensajes.InformacionIncompleta(this, "No Recibo");
            return;
        }
        if (Total > 0) {
            if (ValidoMontos(txtMontoFisico.getText(), txtIMI.getText(), txtIR.getText())) {
                if (VerificarReciboCero()) {
                    if (VerificarCuentasSaldadas()) {
                        int Decision = JOptionPane.showConfirmDialog(this, "Hemos detectado que algunos registros serán saldados, realmente desea guardar el recibo? \nEste proceso es irrevercible", "Atención", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (Decision == 0) {
                            if (Guardar()) {
                                Mensajes.OperacionExitosa(this);
                                ifrEstadoCuentas.CargarClientes();
                                if (ifrRegistroFacturas.RegistroFacturasActiva) {
                                    ifrRegistroFacturas.CargarTabla();
                                }
                                dispose();
                            } else {
                                Mensajes.ErrorDesconocido(this, "No se pudo guardar la información, verifique que el número de Recibo que está ingresando aún no existe");
                            }
                        }
                    } else {
                        int Decision = JOptionPane.showConfirmDialog(this, Mensajes.CONFIRMA_INSERSION + " \nEste proceso es Irreversible", "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (Decision == 0) {
                            if (Guardar()) {
                                Mensajes.OperacionExitosa(this);
                                ifrEstadoCuentas.CargarClientes();
                                if (ifrRegistroFacturas.RegistroFacturasActiva) {
                                    ifrRegistroFacturas.CargarTabla();
                                }
                                dispose();
                            } else {
                                Mensajes.ErrorDesconocido(this, "No se pudo guardar la información, verifique que el número de Recibo que está ingresando aún no existe");
                            }
                        }
                    }
                } else {
                    Mensajes.ErrorMessage(this, "No es posible Guardar", "No se puede Guardar un Recibo con Monto 0.00");
                }
            } else {
                Mensajes.ErrorMessage(this, "No es posible Guardar", "No se puede Guardar debido a que el monto del Recibo de sistema y el Monto Total del Recibo físico no coinciden");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMontoFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoFisicoActionPerformed
        JTextValid.EnviarFoco(txtMontoFisico, txtIMI);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoFisicoActionPerformed

    private void txtIMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIMIActionPerformed
        JTextValid.EnviarFoco(txtIMI, txtIR);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIMIActionPerformed

    private void txtIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIRActionPerformed
        JTextValid.EnviarFoco(txtIR, btnGuardar);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIRActionPerformed

    private void txtNumeroReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroReciboActionPerformed
        JTextValid.EnviarFoco(txtNumeroRecibo, txtMontoFisico);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroReciboActionPerformed

    private void jTable1SelectionChanged(ListSelectionEvent e) {
        if (UtilTable.isAnyoneSelected(tblDeudas)) {
            try {
                txtMontoPagar.setText(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 2).toString().replaceAll(",", ""));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Formateo Numerico", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMontoRecibo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDeudas;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtIMI;
    private javax.swing.JTextField txtIR;
    private javax.swing.JTextField txtMontoFisico;
    private javax.swing.JTextField txtMontoPagar;
    private javax.swing.JTextField txtNumeroRecibo;
    // End of variables declaration//GEN-END:variables

    private void CargarDeudasCliente() {
        DefaultTableModel modelo = (DefaultTableModel) tblDeudas.getModel();
        UtilTable.LimpiarTabla(modelo);

        facturas = facturasBean.ObtenerFacturasClientes(IdCliente);
        double MontoCR, Iva = 0, MontoPagadoCR = 0, MontoPagadoND = 0, TotalPagadoND = 0;

        for (Factura f : facturas) {
            MontoCR = 0;
            Iva = 0;
            MontoPagadoCR = 0;
            MontoPagadoND = 0;
            TotalPagadoND = 0;

            if (f.getEstado().equals("Impresa") || f.getEstado().equals("Impresa con ND")) { //Si la fatura esta pagada no sumo su monto a la deuda pero procedo a buscar si tiene notas de debito sin pagar
                Serviciosagencia sa = servicioAgenciaBean.FindById(f.getCuentaRegistro());
                if (sa == null) {
                    MontoCR = 0.00;
                    Iva = 0.00;
                } else {
                    MontoCR = sa.getHonorario() + sa.getManejo() + sa.getPartidasAdicionales() + sa.getValorizacion();
                    if (sa.getAplicaIva()) {
                        Iva = MontoCR * 0.15;
                    }
                }

                MontoPagadoCR = detalleReciboBean.MontoPagado(true, f.getCuentaRegistro());

                modelo.addRow(new Object[]{
                    "Cuenta de Registro",
                    f.getCuentaRegistro(),
                    String.format("%,.2f", (MontoCR + Iva - MontoPagadoCR))});

            }
            notasDebito = notaDebitoBean.FindAll(f.getCuentaRegistro());
            if (!notasDebito.isEmpty()) {
                for (Notadebito nd : notasDebito) {
                    if (nd.getEstado().equals("Impresa")) {
                        detalleNotaDebitos = debitoBean.FindAll(nd.getNotaDebito());
                        double MontoND = 0.00;
                        if (!detalleNotaDebitos.isEmpty()) {
                            for (Detallenotadebito dnd : detalleNotaDebitos) {
                                MontoND = MontoND + dnd.getMonto();
                            }
                        }

                        MontoPagadoND = detalleReciboBean.MontoPagado(false, nd.getNotaDebito());
                        TotalPagadoND = TotalPagadoND + MontoPagadoND;
                        modelo.addRow(new Object[]{
                            "Nota de Débito",
                            nd.getNotaDebito(),
                            String.format("%,.2f", (MontoND - MontoPagadoND))});
                    }
                }
            }
        }

        //NUEVO AGREGADO PARA PODER OBTENER LAS NOTAS DE DEBITO QUE NO SON ASOCIADAS A CUENTAS DE REGISTRO PERO SI A UN CLIENTE
        notasDebito = null;
        MontoCR = 0;
        Iva = 0;
        MontoPagadoCR = 0;
        MontoPagadoND = 0;
        TotalPagadoND = 0;

        notasDebito = notaDebitoBean.FindAllCliente(IdCliente);
        if (!notasDebito.isEmpty()) {
            for (Notadebito nd : notasDebito) {
                if (nd.getEstado().equals("Impresa")) {
                    detalleNotaDebitos = debitoBean.FindAll(nd.getNotaDebito());
                    double MontoND = 0.00;
                    if (!detalleNotaDebitos.isEmpty()) {
                        for (Detallenotadebito dnd : detalleNotaDebitos) {
                            MontoND = MontoND + dnd.getMonto();
                        }
                    }

                    MontoPagadoND = detalleReciboBean.MontoPagado(false, nd.getNotaDebito());
                    TotalPagadoND = TotalPagadoND + MontoPagadoND;
                    modelo.addRow(new Object[]{
                        "Nota de Débito",
                        nd.getNotaDebito(),
                        String.format("%,.2f", (MontoND - MontoPagadoND))});
                }
            }

        }
    }

    private void InicializarEncabezado() {
        cliente = clientesBean.FindById(IdCliente);
        try {
            IdRecibo = reciboBean.NoReciboConsecutivo();
        } catch (NullPointerException e) {
            IdRecibo = 1;
        }
        lblTitulo.setText("<html><Strong>RECIBO al Cliente '" + cliente.getRazonSocial() + "'");
    }

    private void VerificarMontos() {
        double SaldoDeudor;
        double MontoAPagar = Double.parseDouble(txtMontoPagar.getText());
        try {
            SaldoDeudor = Double.parseDouble(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 2).toString().replaceAll(",", ""));

        } catch (NumberFormatException e) {
            SaldoDeudor = 0;
        }
        if (SaldoDeudor - MontoAPagar < 0) {
            Mensajes.ErrorMessage(this, "Error en el Monto a Pagar", "No puede pagar mas de lo que debe, asegurese de ingresar el monto a pagar en correspondencia con el monto de la deuda");
            return;
        }
        if (SaldoDeudor - MontoAPagar >= 0) {

            tblDeudas.setValueAt(String.format("%,.2f", (SaldoDeudor - MontoAPagar)), tblDeudas.getSelectedRow(), 2);

            AgregarFila(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 0).toString(),
                    tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 1).toString(),
                    MontoAPagar);
            Total = MontoAPagar + Total;
        }
        ActualizarMontoRecibo();

    }

    private void AgregarFila(String TipoCuenta, String IdRegistro, double Monto) {
        DefaultTableModel modelo = (DefaultTableModel) tblPagos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 1).toString().equals(IdRegistro)) {
                modelo.setValueAt((Monto + Double.parseDouble(modelo.getValueAt(i, 2).toString().replace(",", ""))), i, 2);
                return;
            }
        }
        modelo.addRow(new Object[]{TipoCuenta, IdRegistro, Monto});
    }

    private void ActualizarMontoRecibo() {
        lblMontoRecibo.setText("<html><Strong>Monto del Recibo: C$ " + String.format("%,.2f", Total));
    }

    private void RemoverFila(String IdRegistro, double Monto) {
        DefaultTableModel modelo = (DefaultTableModel) tblDeudas.getModel();
        DefaultTableModel modeloTemp = (DefaultTableModel) tblPagos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 1).toString().equals(IdRegistro)) {
                modelo.setValueAt((Monto + Double.parseDouble(modelo.getValueAt(i, 2).toString().replace(",", ""))), i, 2);
                modeloTemp.removeRow(tblPagos.getSelectedRow());
                return;
            }
        }
    }

    private void RetornarMonto() {
        double Monto = Double.parseDouble(tblPagos.getValueAt(tblPagos.getSelectedRow(), 2).toString());
        RemoverFila(tblPagos.getValueAt(tblPagos.getSelectedRow(), 1).toString(),
                Monto);
        Total = Total - Monto;
        ActualizarMontoRecibo();
    }

    private boolean VerificarCuentasSaldadas() {
        boolean CuentasSaldadas = false;
        detalleRecibosTemp = new ArrayList<>();
        for (int i = 0; i < tblDeudas.getRowCount(); i++) {
            if (tblDeudas.getValueAt(i, 2).toString().equals("0.00")) {
                Detallerecibo dr = new Detallerecibo();
                if (tblDeudas.getValueAt(i, 0).toString().equals("Cuenta de Registro")) {
                    dr.setFactura(facturasBean.FindById(Integer.parseInt(tblDeudas.getValueAt(i, 1).toString())));
                    dr.setNotadebito(null);
                } else {
                    dr.setFactura(null);
                    dr.setNotadebito(notaDebitoBean.findById(Integer.parseInt(tblDeudas.getValueAt(i, 1).toString())));
                }
                detalleRecibosTemp.add(dr);
                CuentasSaldadas = true;
            }
        }
        return CuentasSaldadas;
    }

    private boolean Guardar() {
        boolean Guardo = false;
        Detallerecibo dr;
        recibo = new Recibo();
        recibo.setNoRecibo(Integer.parseInt(txtNumeroRecibo.getText()));
        recibo.setCliente(clientesBean.FindById(IdCliente));
        recibo.setMonto(Double.parseDouble((txtMontoFisico.getText().equals("")) ? "0.00" : txtMontoFisico.getText()));
        recibo.setImi(Double.parseDouble((txtIMI.getText().equals("")) ? "0.00" : txtIMI.getText()));
        recibo.setIr(Double.parseDouble((txtIR.getText().equals("")) ? "0.00" : txtIR.getText()));
        recibo.setUsuarioByUserCreacion(SessionHelper.usuario);
        recibo.setFechaCreacion(new Date());
        recibo.setUsuarioByUserModificacion(SessionHelper.usuario);
        recibo.setFechaModificacion(new Date());

        if (GuardarRegistro(recibo)) {
            Guardo = true;
        } else {
            return false;
        }

        for (int i = 0; i < tblPagos.getRowCount(); i++) {
            dr = new Detallerecibo();
            String TipoRegistro = tblPagos.getValueAt(i, 0).toString();
            dr.setRecibo(recibo);
            if (TipoRegistro.equals("Cuenta de Registro")) {
                dr.setFactura(facturasBean.FindById(Integer.parseInt(tblPagos.getValueAt(i, 1).toString())));
            } else {
                dr.setNotadebito(notaDebitoBean.findById(Integer.parseInt(tblPagos.getValueAt(i, 1).toString())));
            }
            dr.setMonto(Double.parseDouble(tblPagos.getValueAt(i, 2).toString()));
            dr.setUserCreacion(SessionHelper.usuario.getIdUsuario());
            dr.setFechaCreacion(new Date());
            dr.setUserModificacion(SessionHelper.usuario.getIdUsuario());
            dr.setFechaModificacion(new Date());

            if (GuardarRegistro(dr)) {
                Guardo = true;
            } else {
                return false;
            }

        }

        if (!detalleRecibosTemp.isEmpty()) {
            for (Detallerecibo detreRecibo : detalleRecibosTemp) {
                if (detreRecibo.getFactura() != null) {
//                        if (tblPagos.getValueAt(i, 1).toString().equals("" + detreRecibo.getFactura() == null ? "" : detreRecibo.getFactura().getCuentaRegistro())) {

                    Factura f = facturasBean.FindById(detreRecibo.getFactura() == null ? -1 : detreRecibo.getFactura().getCuentaRegistro());
                    f.setEstado("Pagada");

                    if (ActualizarRegistro(f)) {
                        Guardo = true;
                    } else {
                        return false;
                    }
                    //GUARDAR FACTURA
//                        }

                } else {
//                        if (tblPagos.getValueAt(i, 1).toString().equals("" + detreRecibo.getNotadebito() == null ? "" : detreRecibo.getNotadebito().getNotaDebito())) {
                    Notadebito n = notaDebitoBean.findById(detreRecibo.getNotadebito() == null ? -1 : detreRecibo.getNotadebito().getNotaDebito());
                    if (n != null) {
                        n.setEstado("Pagada");
                        if (ActualizarRegistro(n)) {
                            Guardo = true;
                        } else {
                            return false;
                        }
                    }
                    //GUARDAR NOTA DEBITO
                }
            }
        }

        return Guardo;
    }

    private boolean GuardarRegistro(Object recibo) {
        try {
            Dbcontext.guardar(recibo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean ActualizarRegistro(Object recibo) {
        try {
            Dbcontext.actualizar(recibo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void IniciarValidator() {
        Validador.Validar(txtMontoPagar, Validador.NUMEROS_POS_DEC);
        Validador.Validar(txtNumeroRecibo, Validador.NUMEROS_POS_DEC);
        Validador.Validar(txtMontoFisico, Validador.NUMEROS_POS_DEC);
        Validador.Validar(txtIMI, Validador.NUMEROS_POS_DEC);
        Validador.Validar(txtIR, Validador.NUMEROS_POS_DEC);

    }

    private boolean ValidoMontos(String Monto, String IMI, String IR) {
        boolean Iguales = false;
        double MontoFijo = Double.parseDouble(String.format("%.2f", Total));
        double MontoD = Double.parseDouble((Monto.equals("")) ? "0.00" : Monto);
        double IMID = Double.parseDouble((IMI.equals("")) ? "0.00" : IMI);
        double IRD = Double.parseDouble((IR.equals("")) ? "0.00" : IR);
        double MontoDigitado = MontoD + IMID + IRD;
        if (MontoFijo == MontoDigitado) {
            Iguales = true;
        } else if (Math.abs(MontoFijo - MontoDigitado) < 1) {
            Iguales = ConsultarMontosDiferentes(MontoFijo, MontoDigitado);
        } else {
            Iguales = false;
        }

        return Iguales;
    }

    private boolean VerificarReciboCero() {
        boolean CuentaCero = false;
        if (Total > 0) {
            CuentaCero = true;
        }
        return CuentaCero;
    }

    private boolean ConsultarMontosDiferentes(double MontoFijo, double MontoDigitado) {
        if (JOptionPane.showConfirmDialog(this, "Hemos detectado que el monto del Recibo de sistema y el Monto Total del Recibo físico no coinciden\nMONTO EN SISTEMA: " + MontoFijo + "\nMONTO DIGITADO: " + MontoDigitado + "\nEs probable que la diferencia sea por algunos decimales, ¿realmente desea guardar este recibo?, este proceso es irreversible", "Confirmación de creación de recibo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
