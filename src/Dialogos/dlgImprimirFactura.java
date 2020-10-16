/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.Dbcontext;
import Conexion.SessionHelper;
import InternalFrames.ifrRegistroFacturas;
import static InternalFrames.ifrRegistroFacturas.CargarTabla;
import POJOs.Agencia;
import POJOs.Cliente;
import POJOs.Detallenotadebito;
import POJOs.Factura;
import POJOs.Notadebito;
import POJOs.Serviciosagencia;
import Reportes.Reporte;
import Utilidad.Mensajes;
import bean.AgenciaBean;
import bean.ClienteBean;
import bean.DetalleNotaDebitoBean;
import bean.FacturasBean;
import bean.NotaDebitoBean;
import bean.ServicioAgenciaBean;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel-Zamora
 */
public class dlgImprimirFactura extends javax.swing.JDialog {

    FacturasBean facturasBean = new FacturasBean();
    ServicioAgenciaBean servicioAgenciaBean = new ServicioAgenciaBean();
    ClienteBean clienteBean = new ClienteBean();
    NotaDebitoBean notaDebitoBean = new NotaDebitoBean();
    DetalleNotaDebitoBean detalledebitoBean = new DetalleNotaDebitoBean();
    AgenciaBean agenciaBean = new AgenciaBean();
    Factura f;
    int CuentaRegistro = 16170;
    Cliente c;
    Agencia a;
    Serviciosagencia sa;
    String TipoTransaccion, TipoLlegada = "";
    double IVA = 0;
    double TotalFactura = 0;
    double TotalND = 0;
    String NDGenerada = "";
    boolean YaPregunto = false;
    String DetalleNotaDebito = "";
    String NotaDebito = "";

    /**
     * Creates new form dlgImprimirFactura
     */
    public dlgImprimirFactura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public dlgImprimirFactura(java.awt.Frame parent, boolean modal, int CuentaRegistro) {
        super(parent, modal);
        this.CuentaRegistro = CuentaRegistro;
        this.f = facturasBean.FindById(CuentaRegistro);
        this.c = clienteBean.FindById(f.getCliente().getIdCliente());
        this.a = agenciaBean.FindById(f.getAgencia().getIdAgencia());
        this.sa = servicioAgenciaBean.FindById(CuentaRegistro);
        initComponents();
        lblTitulo.setText("<html><Strong>VISTA PREVIA CUENTA DE REGISTRO #" + CuentaRegistro);

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
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDocAdj = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        chkND = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("<html><Strong>VISTA PREVIA CUENTA DE REGISTRO #0000");
        jPanel1.add(lblTitulo);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGuardar1.setText("Generar Arch. Vista Previa");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar1);

        btnGuardar.setText("Generar Arch. Impresión");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jEditorPane1.setEditable(false);
        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jEditorPane1);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Doc.Adjuntos"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        txtDocAdj.setColumns(20);
        txtDocAdj.setRows(5);
        txtDocAdj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocAdjKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocAdjKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDocAdj);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5);

        chkND.setText("Incluir Monto de Notas de Débito en el Archivo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(chkND)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(chkND)
                .addContainerGap())
        );

        jPanel4.add(jPanel6);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(725, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (ValidarCampos()) {
            if (YaPregunto == false) {
                if (txtDocAdj.isEditable()) {
                    int Decision = JOptionPane.showConfirmDialog(this, "Esta a punto de Generar un Archivo de Impresion, \nesto provocará que no sea posible editar la Cuenta de Registro, \n¿realmente desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (Decision == 0) {
                        Imprimir(false);
                    }
                } else {
                    Imprimir(false);
                }
            } else {
                Imprimir(false);
            }
            dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Load();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        Imprimir(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtDocAdjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocAdjKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocAdjKeyTyped

    private void txtDocAdjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocAdjKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (txtDocAdj.getLineCount() > 8) {
                Mensajes.WarningMessage(this, "No se pueden agregar mas documentos adjuntos", "El formato de Impresión no permite escribir mas de 8 lineas de documentos adjuntos");
                evt.consume();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocAdjKeyPressed

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
            java.util.logging.Logger.getLogger(dlgImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgImprimirFactura dialog = new dlgImprimirFactura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JCheckBox chkND;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDocAdj;
    // End of variables declaration//GEN-END:variables

    private void Load() {
        String Informacion;

        List<Notadebito> listaNotaDebitos = notaDebitoBean.FindAll(CuentaRegistro);

        if (f.getTipoTransaccion()) {
            TipoTransaccion = "Importacion";
        } else {
            TipoTransaccion = "Exportacion";
        }

        switch (f.getTipoLlegada()) {
            case "1": {
                TipoLlegada = "Terrestre";
            }
            break;
            case "2": {
                TipoLlegada = "Maritima";
            }
            break;
            case "3": {
                TipoLlegada = "Aerea";
            }
            break;
        }
        TotalFactura = sa.getHonorario() + sa.getManejo() + sa.getValorizacion() + sa.getPartidasAdicionales();
        Informacion = "<br>Empresa:&ensp;<strong>" + c.getRazonSocial().toUpperCase() + "</strong>&emsp;&ensp;&ensp;&ensp; RUC:&ensp;<strong>" + c.getRuc() + "</strong>&emsp;&ensp;&ensp;&ensp; Dirección:&ensp;<strong>" + c.getDireccion().toUpperCase() + "</strong><br>";
        Informacion = Informacion + "<br>Hemos cargado a su cuenta por los gastos de registro de:&ensp;<strong><u>" + f.getDescripcion() + ", Aduana " + a.getNombre().toUpperCase() + ", Declaración de " + TipoTransaccion.toUpperCase() + " " + f.getNumeroDeclaracion().toUpperCase() + "</u></strong><br>";
        Informacion = Informacion + "<br>Que llegando vía:&ensp;<strong>" + TipoLlegada.toUpperCase() + "</strong><br>";
        Informacion = Informacion + "<br>Remitidos por:&ensp;&ensp;&ensp;&ensp;<strong>" + f.getRemite().toUpperCase() + "</strong><br><br>Factura No.&ensp;<strong>" + f.getFacturaExterna() + "</strong>&emsp;&emsp;&emsp;&ensp;&ensp;Valor CIF:&ensp;<strong><u>C$" + String.format("%,.2f", f.getValorCif()) + "</u></strong><br>";
        Informacion = Informacion + "<br><br><strong>----SERVICIOS DE AGENCIA ADUANERA----</strong><br><br>";

        Informacion = Informacion + "<table><tbody>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'>HONORARIOS</td>"
                + "<td>C$" + String.format("%,.2f", sa.getHonorario()) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'>MANEJO</td>"
                + "<td >C$" + String.format("%,.2f", sa.getManejo()) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'>VALORIZACION</td>"
                + "<td >C$" + String.format("%,.2f", sa.getValorizacion()) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'>PARTIDAS ADICIONALES</td>"
                + "<td >C$" + String.format("%,.2f", sa.getPartidasAdicionales()) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'><strong>15% IVA</strong></td>";

        if (sa.getAplicaIva()) {
            IVA = TotalFactura * 0.15;
        } else {
            IVA = 0;
        }
        Informacion = Informacion
                + "<td>C$" + String.format("%,.2f", IVA) + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'><strong>TOTAL SIN ND</strong></td>"
                + "<td ><strong>C$" + String.format("%,.2f", (TotalFactura + IVA)) + "</strong></td>"
                + "</tr>";

        
        for (Notadebito listaNotaDebito : listaNotaDebitos) {
            if (!listaNotaDebito.getEstado().equals("Anulada") && !listaNotaDebito.getEstado().equals("Pagada")) {
                List<Detallenotadebito> listaDetalles = detalledebitoBean.FindAll(listaNotaDebito.getNotaDebito());
                String TempDetalle = "Detalles: ";
                double TempTotal = 0;
                for (Detallenotadebito listaDetalle : listaDetalles) {

                    TempDetalle = TempDetalle + "" + listaDetalle.getDetalle() + " (C$" + String.format("%,.2f", listaDetalle.getMonto()) + "), ";
                    TempTotal += listaDetalle.getMonto();
                    TotalND = TotalND + listaDetalle.getMonto();
                }
                NotaDebito = NotaDebito + listaNotaDebito.getNotaDebito() + ",";
                DetalleNotaDebito = DetalleNotaDebito + "Nota de Débito No." + listaNotaDebito.getNotaDebito() + " Total C$" + String.format("%,.2f", TempTotal) + "\n" + TempDetalle.substring(0,TempDetalle.length()-2) + "\n ";
            }
            if (listaNotaDebito.getEstado().equals("Generada")) {
                NDGenerada = "La Nota de Débito " + listaNotaDebito.getNotaDebito() + " aún no ha sido Impresa";
            }
        }
        
//        DetalleNotaDebito = DetalleNotaDebito + "\nTOTAL NOTA(S) DE DEBITO ("+NotaDebito.substring(0, NotaDebito.length() - 1)+") C$"+String.format("%,.2f", TotalND);

        Informacion = Informacion
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'>TOTAL NOTAS DE DEBITO(" + ((NotaDebito.length() > 0) ? NotaDebito.substring(0, NotaDebito.length() - 1) : "") + ")</td>"
                + "<td >C$" + String.format("%,.2f", TotalND) + "</td>"
                + "</tr>";
        Informacion = Informacion
                + "<tr>"
                + "<td style='margin:0 50px 0 10px;'><strong>TOTAL A PAGAR</strong></td>"
                + "<td ><strong>C$" + String.format("%,.2f", (TotalFactura + IVA + TotalND)) + "</strong></td>"
                + "</tr>";
        Informacion = Informacion + "</tbody></table><br>";
        jEditorPane1.setText(Informacion);
        if (!f.getEstado().equals("Generada") && !f.getEstado().equals("Modificada")) {
            txtDocAdj.setText(f.getDocsAdjuntos());
            txtDocAdj.setEditable(false);
            if (f.getEstado().equals("Impresa con ND")) {
                chkND.setSelected(true);
            }
            chkND.setEnabled(false);
            btnGuardar1.setEnabled(false);
        }
    }

    private boolean ValidarCampos() {
        if (txtDocAdj.isEditable()) {
            if (txtDocAdj.getText().equals("")) {
                int Decision = JOptionPane.showConfirmDialog(this, "Esta a punto de Generar un Archivo de Impresion sin Documentos Adjuntos, ¿realmente desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (Decision == 0) {
                    YaPregunto = true;
                    return VerificarAdjuntaND();
                } else {
                    return false;
                }
            } else {
                return VerificarAdjuntaND();
            }
        } else {
            return true;
        }
    }

    private boolean VerificarAdjuntaND() {
        if (chkND.isSelected()) {
            if (NDGenerada.length() > 0) {
                Mensajes.InfoMessage(this, "Falta imprimir algunas Cuentas", "Hemos detectado que " + NDGenerada + "\nFavor Imprima dicha nota para poder continuar");
                return false;
            } else {
                int Decision = JOptionPane.showConfirmDialog(this, "Esta a punto de Generar un Archivo de Impresion con su Monto de Nota de Débito, \nesto provocará que no sea posible editar la o las Notas de Débito asociadas a la Cuenta de Registro, \n¿realmente desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (Decision == 0) {
                    YaPregunto = true;
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    private void Imprimir(boolean IsPreview) {

        Reporte reporte = new Reporte("RptFactura.jasper");
        reporte.AddParameter("empresa", c.getRazonSocial().toUpperCase());
        reporte.AddParameter("ruc", c.getRuc());
        reporte.AddParameter("lugar", c.getDireccion().toUpperCase());
        reporte.AddParameter("transporte", TipoLlegada);
        reporte.AddParameter("remisor", f.getRemite().toUpperCase());
        reporte.AddParameter("factura", f.getFacturaExterna());
        reporte.AddParameter("cif", f.getValorCif());

        reporte.AddParameter("srvHonorarios", sa.getHonorario());
        reporte.AddParameter("srvManejo", sa.getManejo());
        reporte.AddParameter("srvValorizacion", sa.getValorizacion());
        reporte.AddParameter("srvPartidas", sa.getPartidasAdicionales());
        reporte.AddParameter("nocuentaregistro", f.getCuentaRegistro());
        reporte.AddParameter("iva", IVA);
        
        if (chkND.isSelected()) {
        reporte.AddParameter("pagosCliente", DetalleNotaDebito);
            reporte.AddParameter("notaDebito", new Double("" + TotalND));
            reporte.AddParameter("total", (TotalFactura + IVA + TotalND));
            reporte.AddParameter("noNotaDebito", "("+NotaDebito.substring(0, NotaDebito.length()-1)+")");
        } else {
            reporte.AddParameter("total", (TotalFactura + IVA));
            reporte.AddParameter("pagosCliente", "");
        }
        if (!IsPreview) { // Si no es vista previa pues guardamos
            if (f.getEstado().equals("Generada") || f.getEstado().equals("Modificada")) {
                reporte.AddParameter("fecha", new Date());
                if (chkND.isSelected()) {
                    f.setEstado("Impresa con ND");
                } else {
                    f.setEstado("Impresa");
                }
                f.setDocsAdjuntos(txtDocAdj.getText());
                f.setUsuarioByUserImpresion(SessionHelper.usuario);
                f.setFechaImpresion(new Date());
                try {

                    Dbcontext.actualizar(f);

                } catch (Exception e) {
                    Mensajes.ErrorDesconocido(this, e.getMessage());
                }
                if (ifrRegistroFacturas.RegistroFacturasActiva) {
                    CargarTabla();
                }
            } else {
                reporte.AddParameter("fecha", f.getFechaImpresion());
            }
        } else if (f.getEstado().equals("Generada") || f.getEstado().equals("Modificada")) {
            reporte.AddParameter("fecha", new Date());
        } else {
            reporte.AddParameter("fecha", f.getFechaImpresion());
        }
        try {
            System.out.println(f.getDocsAdjuntos());
            if (IsPreview) {
                reporte.AddParameter("docAdjunto", "Vista Previa");
            } else {
                reporte.AddParameter("docAdjunto", f.getDocsAdjuntos().equals("") ? " " : f.getDocsAdjuntos());
            }
        } catch (NullPointerException e) {
            if (IsPreview) {
                reporte.AddParameter("docAdjunto", "Vista Previa");
            } else {
                reporte.AddParameter("docAdjunto", " ");
            }
        }

        reporte.AddParameter("descripcion", f.getDescripcion() + " Aduana " + a.getNombre() + ", Declaración de " + TipoTransaccion + " #" + f.getNumeroDeclaracion());
        reporte.setZoom(1f);
        reporte.Show();

    }

}