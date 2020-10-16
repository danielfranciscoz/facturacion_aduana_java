package agenciaaduanera;

import Conexion.SessionHelper;
import Dialogos.dlgAcercaDe;
import Dialogos.dlgAgencia;
import Dialogos.dlgClientes;
import Dialogos.dlgSeguridadEmpleados;
import Dialogos.dlgFacturar;
import Dialogos.dlgProductos;
import Dialogos.dlgSeguridadPerfil;
import InternalFrames.ifrEstadoCuentas;
import InternalFrames.ifrRegistroClientes;
import InternalFrames.ifrRegistroEmpleados;
import InternalFrames.ifrRegistroFacturas;
import InternalFrames.ifrResgistroRolesPermisos;
import InternalFrames.ifrResgistroUsuarios;
import Utilidad.UtilDate;
import Utilidad.clsinfo;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * @author Daniel-Zamora
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "ImageRotator");
        initComponents();
        IniciarStatus();

    }

    @Override
    public Image getIconImage() {
        Image refValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos/Logo.png"));
        return refValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnAddFactura = new javax.swing.JButton();
        btnAddCliente = new javax.swing.JButton();
        btnAddProducto = new javax.swing.JButton();
        btnAddEmpleado = new javax.swing.JButton();
        btnAduana = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar2 = new javax.swing.JToolBar();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel1 = new javax.swing.JLabel();
        lblUsuarioSesion = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel7 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        lblFechaSesion = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jMenuBar1 = new javax.swing.JMenuBar();
        menuRegistros = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        miClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        miFacturas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        miEmpleados = new javax.swing.JMenuItem();
        miUsuarios = new javax.swing.JMenuItem();
        miRolesPermisos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Administracion Aduanera SIAA V "+clsinfo.version);
        setExtendedState(6);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnAddFactura.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAddFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/facturar_40.png"))); // NOI18N
        btnAddFactura.setText("Factura");
        btnAddFactura.setFocusable(false);
        btnAddFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacturaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddFactura);

        btnAddCliente.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clientes_40.png"))); // NOI18N
        btnAddCliente.setText("Cliente");
        btnAddCliente.setFocusable(false);
        btnAddCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddCliente);

        btnAddProducto.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAddProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/productos_40.png"))); // NOI18N
        btnAddProducto.setText("Producto");
        btnAddProducto.setFocusable(false);
        btnAddProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddProducto);

        btnAddEmpleado.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAddEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/empleados_40.png"))); // NOI18N
        btnAddEmpleado.setText("Empleado");
        btnAddEmpleado.setFocusable(false);
        btnAddEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpleadoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAddEmpleado);

        btnAduana.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnAduana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agencias.png"))); // NOI18N
        btnAduana.setText("Aduana");
        btnAduana.setFocusable(false);
        btnAduana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAduana.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAduana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAduanaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAduana);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setLayout(null);
        jPanel2.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jToolBar2.setBackground(new java.awt.Color(51, 51, 51));
        jToolBar2.setFloatable(false);
        jToolBar2.setPreferredSize(new java.awt.Dimension(108, 30));
        jToolBar2.add(filler4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/user_24.png"))); // NOI18N
        jLabel1.setText("Usuario:");
        jToolBar2.add(jLabel1);

        lblUsuarioSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsuarioSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioSesion.setText("Usuario");
        jToolBar2.add(lblUsuarioSesion);
        jToolBar2.add(filler3);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/lock_24.png"))); // NOI18N
        jLabel7.setText("Cargo:");
        jToolBar2.add(jLabel7);

        lblRol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("admin");
        jToolBar2.add(lblRol);
        jToolBar2.add(filler1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/calendar_24.png"))); // NOI18N
        jLabel2.setText("Fecha:");
        jToolBar2.add(jLabel2);

        lblFechaSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFechaSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaSesion.setText("dd/mm/aaaa");
        jToolBar2.add(lblFechaSesion);
        jToolBar2.add(filler2);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.SOUTH);

        menuRegistros.setText("CLIENTES | VENTAS");
        menuRegistros.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jMenu1.setText("Clientes");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        miClientes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        miClientes.setText("Cartera de Clientes");
        miClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClientesActionPerformed(evt);
            }
        });
        jMenu1.add(miClientes);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem1.setText("Estados de Cuenta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuRegistros.add(jMenu1);

        miFacturas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        miFacturas.setText("Facturas");
        miFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFacturasActionPerformed(evt);
            }
        });
        menuRegistros.add(miFacturas);

        jMenuBar1.add(menuRegistros);

        jMenu3.setText("ADMINISTRACIÓN");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem11.setText("Perfil Actual");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        miEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        miEmpleados.setText("Empleados");
        miEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmpleadosActionPerformed(evt);
            }
        });
        jMenu3.add(miEmpleados);

        miUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        miUsuarios.setText("Usuarios");
        miUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuariosActionPerformed(evt);
            }
        });
        jMenu3.add(miUsuarios);

        miRolesPermisos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        miRolesPermisos.setText("Roles - Permisos");
        miRolesPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRolesPermisosActionPerformed(evt);
            }
        });
        jMenu3.add(miRolesPermisos);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("AYUDA");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem8.setText("Manual");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem6.setText("Acerca de");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem7.setText("Salir");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(713, 544));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClientesActionPerformed
        ifrRegistroClientes registroClientes = new ifrRegistroClientes();
        if (estacerrado(registroClientes)) {
            jDesktopPane1.add(registroClientes);
            Centrar(jDesktopPane1, registroClientes);
            registroClientes.show();
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA CLIENTES YA ESTA ABIERTA");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_miClientesActionPerformed

    private void miFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFacturasActionPerformed
        ifrRegistroFacturas registroFacturas = new ifrRegistroFacturas();

        if (estacerrado(registroFacturas)) {
            jDesktopPane1.add(registroFacturas);
            Centrar(jDesktopPane1, registroFacturas);
            try {
                registroFacturas.setMaximum(true);
            } catch (PropertyVetoException ex) {
            }
            registroFacturas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA FACTURAS YA ESTA ABIERTA");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_miFacturasActionPerformed

    private void miRolesPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRolesPermisosActionPerformed
        // TODO add your handling code here:
        ifrResgistroRolesPermisos dlgpermisos = new ifrResgistroRolesPermisos();
        if (estacerrado(dlgpermisos)) {
            jDesktopPane1.add(dlgpermisos);
            Centrar(jDesktopPane1, dlgpermisos);
            dlgpermisos.show();
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA ROLES-PERMISOS YA ESTA ABIERTA");
        }
    }//GEN-LAST:event_miRolesPermisosActionPerformed

    private void miUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuariosActionPerformed
        // TODO add your handling code here:
        ifrResgistroUsuarios frame = new ifrResgistroUsuarios();
        if (estacerrado(frame)) {
            jDesktopPane1.add(frame);
            Centrar(jDesktopPane1, frame);
            frame.show();
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA USUARIOS YA ESTA ABIERTA");
        }
    }//GEN-LAST:event_miUsuariosActionPerformed

    private void miEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmpleadosActionPerformed
        // TODO add your handling code here:
        ifrRegistroEmpleados frame = new ifrRegistroEmpleados();
        if (estacerrado(frame)) {
            jDesktopPane1.add(frame);
            Centrar(jDesktopPane1, frame);
            frame.show();
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA EMPLEADOS YA ESTA ABIERTA");
        }
    }//GEN-LAST:event_miEmpleadosActionPerformed

    private void btnAddFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacturaActionPerformed
        // TODO add your handling code here:
        new dlgFacturar(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddFacturaActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        // TODO add your handling code here:
        new dlgClientes(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddClienteActionPerformed

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        // TODO add your handling code here:
        new dlgProductos(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void btnAddEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpleadoActionPerformed
        // TODO add your handling code here:
        new dlgSeguridadEmpleados(this, true).setVisible(true);
    }//GEN-LAST:event_btnAddEmpleadoActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int opc = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar su sesión?",
                "Mensaje de Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        new dlgSeguridadPerfil(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ifrEstadoCuentas estadosCuenta = new ifrEstadoCuentas();
        if (estacerrado(estadosCuenta)) {
            jDesktopPane1.add(estadosCuenta);
            Centrar(jDesktopPane1, estadosCuenta);
            estadosCuenta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "LA VENTANA ESTADOS DE CUENTA YA ESTA ABIERTA");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new dlgAcercaDe(this, true).setVisible(true);
        // TODO add your handling code here:        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnAduanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAduanaActionPerformed
        // TODO add your handling code here:
        new dlgAgencia(this, true).setVisible(true);
    }//GEN-LAST:event_btnAduanaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().open(new File("manual.pdf"));
//            Desktop.getDesktop().open(new File(getClass().getResource("manual.pdf").getFile()));
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddEmpleado;
    private javax.swing.JButton btnAddFactura;
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnAduana;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblFechaSesion;
    public javax.swing.JLabel lblRol;
    public javax.swing.JLabel lblUsuarioSesion;
    private javax.swing.JMenu menuRegistros;
    private javax.swing.JMenuItem miClientes;
    private javax.swing.JMenuItem miEmpleados;
    private javax.swing.JMenuItem miFacturas;
    private javax.swing.JMenuItem miRolesPermisos;
    private javax.swing.JMenuItem miUsuarios;
    // End of variables declaration//GEN-END:variables

    private void Centrar(JDesktopPane jdesktopPane, JInternalFrame jinternalFrame) {
        Dimension desktopSize = jdesktopPane.getSize();
        Dimension jInternalFrameSize = jinternalFrame.getSize();
        jinternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    private void IniciarStatus() {
        lblUsuarioSesion.setText(SessionHelper.usuario.getIdUsuario());
        lblRol.setText(SessionHelper.rol.getRol());
        lblFechaSesion.setText(UtilDate.CurrentDate());

        new Thread(() -> {
            // PERMISOS AGREGACION
            SessionHelper.VerificarPermiso(btnAddCliente, "gestion de clientes", "insertar");
            SessionHelper.VerificarPermiso(btnAddEmpleado, "gestion de empleados", "insertar");
            SessionHelper.VerificarPermiso(btnAddProducto, "gestion de productos", "insertar");
            SessionHelper.VerificarPermiso(btnAddFactura, "gestion de facturas", "insertar");

            // MENUS
            SessionHelper.VerificarPantallas(menuRegistros, new String[]{
                "gestion de clientes",
                "gestion de facturas"
            });
            SessionHelper.VerificarPantalla(miClientes, "gestion de clientes");
            SessionHelper.VerificarPantalla(miFacturas, "gestion de facturas");

            SessionHelper.VerificarPantalla(miEmpleados, "gestion de empleados");
            SessionHelper.VerificarPantalla(miUsuarios, "gestion de usuarios");
            SessionHelper.VerificarPantallas(miRolesPermisos, new String[]{
                "gestion de permisos",
                "gestion de roles",
                "gestion de pantallas"
            });
        }).start();
    }

    public boolean estacerrado(Object obj) {

        boolean mostrar = true;
        System.out.println("***" + jDesktopPane1.getComponentCount() + "***");
        for (int a = 0; a < jDesktopPane1.getComponentCount(); a++) {     // verificar si es instancia de algun componente que ya este en el jdesktoppane
            System.out.println(jDesktopPane1.getComponent(a));
            if (obj.getClass().isInstance(jDesktopPane1.getComponent(a))) {
                System.out.println("es instancia, no se debe mostrar");
                mostrar = false;
                break;
            } else {
                mostrar = true;
                System.out.println("no lo es, puede mostrarse");
            }
        }
        return mostrar;
    }
}
