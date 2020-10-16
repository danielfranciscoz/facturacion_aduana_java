package Utilidad;

import Conexion.SessionHelper;
import POJOs.Pantalla;
import POJOs.Permiso;
import bean.PantallaBean;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;

/**
 *
 * @author W4LT3R
 */
public class JButtonSecurity extends javax.swing.JButton {

    PantallaBean pantallaBean = new PantallaBean();
    List<Permiso> permisos = SessionHelper.permisos;

    public JButtonSecurity() {
    }

    public JButtonSecurity(Icon icon) {
        super(icon);
    }

    public JButtonSecurity(String text) {
        super(text);
    }

    public JButtonSecurity(Action a) {
        super(a);
    }

    public JButtonSecurity(String text, Icon icon) {
        super(text, icon);
    }

    public void VerificarPermiso(String nombre_pantalla, String nombre_permiso) {
        this.setVisible(false);
        this.setEnabled(false);
        permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            return pantalla.getRecurso().equals(nombre_pantalla);

        }).forEach((permiso) -> {
            try {
                Field campo = Permiso.class.getDeclaredField(nombre_permiso);
                campo.setAccessible(true);
                boolean value = Boolean.parseBoolean(campo.get(permiso).toString());
                if (value == true) {
                    this.setVisible(true);
                    this.setEnabled(true);
                }
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
    }
}
