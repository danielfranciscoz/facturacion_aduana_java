package Conexion;

import POJOs.Empleado;
import POJOs.Pantalla;
import POJOs.Permiso;
import POJOs.Persona;
import POJOs.Rol;
import POJOs.Usuario;
import bean.PantallaBean;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.List;

public class SessionHelper {

    public static Usuario usuario = new Usuario();
    public static Rol rol = new Rol();
    public static Persona persona = new Persona();
    public static Empleado empleado = new Empleado();
    public static List<Permiso> permisos;

    static PantallaBean pantallaBean = new PantallaBean();

    public static void VerificarPermiso(Component componente, String nombre_pantalla, String permiso_clase) {
        componente.setVisible(false);
        permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            String pantallaname = pantalla.getNombre().trim();
            return pantallaname.equalsIgnoreCase(nombre_pantalla.trim());

        }).forEach((permiso) -> {
            try {
                Field campo = Permiso.class.getDeclaredField(permiso_clase);
                campo.setAccessible(true);
                boolean value = Boolean.parseBoolean(campo.get(permiso).toString());
                if (value == true) {
                    componente.setVisible(true);
                }
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static boolean VerificarPantalla(String nombre_pantalla){
        long cantidad = permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            String pantallaname = pantalla.getNombre().trim();
            return pantallaname.equalsIgnoreCase(nombre_pantalla.trim());
        }).count();
        return cantidad > 0;
    }

    public static void VerificarPantalla(Component componente, String nombre_pantalla) {
        componente.setVisible(false);
        long cantidad = permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            String pantallaname = pantalla.getNombre().trim();
            return pantallaname.equalsIgnoreCase(nombre_pantalla.trim());
        }).count();
        if (cantidad > 0) {
            componente.setVisible(true);
        }
    }

    public static void VerificarPantallas(Component componente, String[] nombre_pantallas) {
        componente.setVisible(false);
        long cantidad = permisos.stream().filter((permiso) -> {
            Pantalla pantalla = pantallaBean.FindById(permiso.getId().getIdPantalla());
            String pantallaname = pantalla.getNombre().trim();
            boolean pantallaIsExists = false;
            for (String nombre_pantalla : nombre_pantallas) {
                if (pantallaname.equalsIgnoreCase(nombre_pantalla.trim())) {
                    pantallaIsExists = true;
                }
            }
            return pantallaIsExists;
        }).count();
        if (cantidad > 0) {
            componente.setVisible(true);
        }
    }
}
