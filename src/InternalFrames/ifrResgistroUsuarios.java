package InternalFrames;

import Dialogos.dlgSeguridadRecoveryPassword;
import Dialogos.dlgSeguridadUsuario;
import POJOs.Empleado;
import POJOs.Persona;
import POJOs.Rol;
import POJOs.Usuario;
import Utilidad.Mensajes;
import Utilidad.UtilDate;
import Utilidad.UtilString;
import Utilidad.UtilTable;
import bean.EmpleadoBean;
import bean.PersonaBean;
import bean.RolBean;
import bean.UsuarioBean;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author W4LT3R
 */
public class ifrResgistroUsuarios extends javax.swing.JInternalFrame {

    static UsuarioBean usuarioBean = new UsuarioBean();
    static EmpleadoBean empleadoBean = new EmpleadoBean();
    static PersonaBean personaBean = new PersonaBean();
    static RolBean rolBean = new RolBean();

    static List<Usuario> usuarios;
    static DefaultTableModel modelTableUsuarios;

    /**
     * Creates new form ifrCargos
     */
    public ifrResgistroUsuarios() {
        initComponents();
        jPanel26.setVisible(false);
        tableUsuarios.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (UtilTable.isAnyoneSelected(tableUsuarios)) {
                Usuario u = usuarioBean.FindById(UtilTable.getSelectedValue(tableUsuarios, 0).toString());
                MostrarInformacion(u);
            }
        });
        modelTableUsuarios = (DefaultTableModel) tableUsuarios.getModel();
        LoadUsuarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblCantidadRegistros = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JEditorPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        txtSearch = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        setClosable(true);
        setMaximizable(true);
        setTitle("Usuarios y Roles");

        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setDividerSize(0);
        jSplitPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane2.setMinimumSize(new java.awt.Dimension(0, 0));
        jSplitPane2.setPreferredSize(new java.awt.Dimension(204, 109));

        jPanel14.setMinimumSize(new java.awt.Dimension(240, 240));
        jPanel14.setLayout(new java.awt.BorderLayout());

        lblCantidadRegistros.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblCantidadRegistros.setText("Cantidad de Registros: 0");
        jPanel15.add(lblCantidadRegistros);

        jPanel14.add(jPanel15, java.awt.BorderLayout.SOUTH);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><strong>Información del Registro"));
        jPanel17.setMinimumSize(new java.awt.Dimension(700, 105));
        jPanel17.setPreferredSize(new java.awt.Dimension(700, 105));
        jPanel17.setLayout(new java.awt.BorderLayout());

        txtDetalles.setEditable(false);
        txtDetalles.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(txtDetalles);

        jPanel17.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel16, java.awt.BorderLayout.CENTER);

        jSplitPane2.setLeftComponent(jPanel14);

        jPanel18.setMinimumSize(new java.awt.Dimension(588, 400));
        jPanel18.setPreferredSize(new java.awt.Dimension(100, 400));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html><Strong>REGISTROS DE USUARIOS");
        jPanel19.add(jLabel8);

        jPanel18.add(jPanel19, java.awt.BorderLayout.PAGE_START);
        jPanel18.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel23.setPreferredSize(new java.awt.Dimension(13, 300));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jScrollPane5.setPreferredSize(new java.awt.Dimension(300, 404));

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Rol", "Creado Por", "Fecha Creación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableUsuarios);

        jPanel23.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel23, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel24.setLayout(new java.awt.BorderLayout());

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel25.add(btnNuevo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel25.add(btnEditar);

        btnRestablecer.setText("Restablecer");
        btnRestablecer.setVisible(false);
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });
        jPanel25.add(btnRestablecer);

        jButton5.setText("Exportar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton5);

        jPanel24.add(jPanel25, java.awt.BorderLayout.SOUTH);

        jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar:");
        jPanel26.add(jLabel6);
        jPanel26.add(filler2);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel26.add(txtSearch);
        jPanel26.add(filler3);

        jPanel24.add(jPanel26, java.awt.BorderLayout.NORTH);

        jPanel21.add(jPanel24, java.awt.BorderLayout.NORTH);

        jPanel18.add(jPanel21, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel18);

        getContentPane().add(jSplitPane2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 993, 521);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        List<Empleado> empleados = empleadoBean.FindAllSinUsuario();
        List<Rol> roles = rolBean.FindAll();
        if (empleados.size() > 0 && roles.size() > 0) {
            new dlgSeguridadUsuario(JOptionPane.getFrameForComponent(this), true).setVisible(true);
        } else if (empleados.size() <= 0) {
            Mensajes.WarningMessage(this, "Creación de usuarios", "No hay empleados disponibles");
        } else {
            Mensajes.WarningMessage(this, "Creación de usuarios", "No hay cargos o roles disponibles");
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (UtilTable.isAnyoneSelected(tableUsuarios)) {
            Usuario user = usuarioBean.FindById(String.valueOf(UtilTable.getSelectedValue(tableUsuarios, 0)));
            dlgSeguridadUsuario dlgUsuario = new dlgSeguridadUsuario(JOptionPane.getFrameForComponent(this), true);
            dlgUsuario.setUsuario(user);
            dlgUsuario.setVisible(true);
        } else {
            Mensajes.SeleccioneFila(this);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        // TODO add your handling code here:
        if (UtilTable.isAnyoneSelected(tableUsuarios)) {
            Usuario user = usuarioBean.FindById(String.valueOf(UtilTable.getSelectedValue(tableUsuarios, 0)));
            new dlgSeguridadRecoveryPassword(JOptionPane.getFrameForComponent(this), true, user).setVisible(true);
        } else {
            Mensajes.SeleccioneFila(this);
        }
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        UtilTable.Exportar(this, tableUsuarios);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane2;
    private static javax.swing.JLabel lblCantidadRegistros;
    private static javax.swing.JTable tableUsuarios;
    private javax.swing.JEditorPane txtDetalles;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public static void LoadUsuarios() {
        UtilTable.LimpiarTabla(tableUsuarios);
        usuarios = usuarioBean.FindAll();
        usuarios.stream().forEach((u) -> {
            String[] fila = new String[4];
            fila[0] = u.getIdUsuario();
//            fila[1] = rolBean.FindById(u.getIdRol()).getRol();
            fila[1] = u.getRol().getRol();
            fila[2] = UtilString.EvitaVacio(u.getUsuarioByUserCreacion() != null ? u.getUsuarioByUserCreacion().getIdUsuario() : "");
            fila[3] = UtilDate.DateNicaraguaFecha(u.getFechaCreacion()) + " " + UtilDate.DateNicaraguaHora(u.getFechaCreacion());
            modelTableUsuarios.addRow(fila);
        });
        lblCantidadRegistros.setText("Cantidad de Registros: " + usuarios.size());
    }

    private void MostrarInformacion(Usuario user) {
        Empleado emp = empleadoBean.FindById(user.getEmpleado().getIdEmpleado());
        Persona persona = personaBean.FindById(user.getEmpleado().getIdEmpleado());
        txtDetalles.setText("<br><strong>No.Empleado: " + emp.getIdEmpleado() + "</strong>"
                + "<br><br>Nombres: <strong>" + UtilString.union(new String[]{persona.getPrimerNombre(), persona.getSegundoNombre()}) + "</strong>"
                + "<br>Apellidos: <strong>" + UtilString.union(new String[]{persona.getPrimerApellido(), persona.getSegundoApellido()}) + "</strong>"
                + "<br>Cédula: <strong>" + UtilString.EvitaVacio(persona.getCedula()) + "</strong>"
                + "<br> Dirección: <strong>" + String.valueOf(persona.getDireccion()) + "</strong>"
                + "<br> Cargo: <strong>" + emp.getCargo() + "</strong>"
                + "<br> Rol: <strong>" + rolBean.FindById(user.getRol().getIdRol()).getRol() + "</strong>"
                + "<br> Salario: <strong>" + String.valueOf(emp.getSalario()) + "</strong>"
                + "<br><br> Fecha de Creación: <strong>" + UtilDate.DateFullNicaragua(emp.getFechaCreacion()) + "</strong>"
                + "<br> Usuario Creador: <strong>" + UtilString.EvitaVacio(emp.getUsuarioByUserCreacion() == null ? "" : emp.getUsuarioByUserCreacion().getIdUsuario()) + "</strong>"
                + "<br><br> Ultima Modificación: <strong>" + UtilDate.DateFullNicaragua(emp.getFechaModificacion()) + "</strong>"
                + "<br> Usuario que Modificó: <strong>" + UtilString.EvitaVacio(emp.getUsuarioByUserModificacion() == null ? "" : emp.getUsuarioByUserModificacion().getIdUsuario()) + "</strong>"
                + "</strong>");
    }
}
