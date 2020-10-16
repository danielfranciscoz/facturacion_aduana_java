package Dialogos;

import Conexion.Dbcontext;
import POJOs.Usuario;
import Utilidad.Cifrado;
import Utilidad.Mensajes;
import java.util.Date;

/**
 *
 * @author W4LT3R
 */
public class dlgSeguridadRecoveryPassword extends javax.swing.JDialog {

    public Usuario user;

    public dlgSeguridadRecoveryPassword(java.awt.Frame parent, boolean modal, Usuario user) {
        super(parent, modal);
        this.user = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPass2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperar Contraseña");
        setResizable(false);

        txtPass2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass2.setEchoChar('●');

        jLabel2.setText("Confirmar Nueva Contraseña");

        txtPass1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass1.setEchoChar('●');

        jLabel1.setText("Nueva Contraseña");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(329, 203));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String pass1 = new String(txtPass1.getPassword());
        String pass2 = new String(txtPass2.getPassword());

        if (!pass1.isEmpty() && !pass2.isEmpty()) {
            if (pass1.equals(pass2)) {
                if (pass1.length() > 5 && pass2.length() > 5) {
                    try {
                        user.setFechaModificacion(new Date());
                        user.setPassword(Cifrado.encrypt(pass2));
                        Dbcontext.actualizar(user);
                        Mensajes.OperacionExitosa(this);
                        dispose();
                    } catch (Exception ex) {
                        Mensajes.ErrorDesconocido(rootPane, ex.getMessage());
                    }
                } else {
                    txtPass1.setText("");
                    txtPass2.setText("");
                    Mensajes.WarningMessage(this, "Login", "Contraseña Nueva, Tamaño minimo 6 caracteres");
                }
            } else {
                txtPass1.setText("");
                txtPass2.setText("");
                Mensajes.WarningMessage(this, "Login", "Contraseñas No son iguales");
            }
        } else {
            Mensajes.InformacionIncompleta(this);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}
