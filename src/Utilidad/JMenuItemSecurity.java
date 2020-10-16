/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import Conexion.SessionHelper;
import POJOs.Pantalla;
import POJOs.Permiso;
import bean.PantallaBean;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

/**
 *
 * @author W4LT3R
 */
public class JMenuItemSecurity extends JMenuItem {

    PantallaBean pantallaBean = new PantallaBean();
    List<Permiso> permisos = SessionHelper.permisos;

    public JMenuItemSecurity() {
    }

    public JMenuItemSecurity(Icon icon) {
        super(icon);
    }

    public JMenuItemSecurity(String text) {
        super(text);
    }

    public JMenuItemSecurity(Action a) {
        super(a);
    }

    public JMenuItemSecurity(String text, Icon icon) {
        super(text, icon);
    }

    public JMenuItemSecurity(String text, int mnemonic) {
        super(text, mnemonic);
    }

    public void VerificarPermiso(String nombre_pantalla, String nombre_permiso) {
        permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            return pantalla.getNombre().equals(nombre_pantalla);

        }).forEach((permiso) -> {
            try {
                Field campo = Permiso.class.getDeclaredField(nombre_permiso);
                campo.setAccessible(true);
                boolean value = Boolean.parseBoolean(campo.get(permiso).toString());
                if (value == true) {
                    this.setVisible(true);
                    this.setEnabled(true);
                } else {
                    this.setVisible(false);
                    this.setEnabled(false);
                }
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                ex.printStackTrace();
                this.setVisible(false);
                this.setEnabled(false);
            }
        });
    }

}