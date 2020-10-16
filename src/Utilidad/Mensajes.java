/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import Conexion.Dbcontext;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel-Zamora
 */
public class Mensajes {

    public static String CONEXION_EXITOSA = "Se realizó la Conexión de manera Exitosa";
    public static String ERROR_CONEXION = "Ocurrió un error durante la conexión";
    public static String ERROR_INESPERADO = "Ocurrió un error";
    public static String ERROR_GESTIONINFO = "Ocurrió un error, No se puedo realizar la operación";

    public static String CONFIRMA_ACTUALIZACION = "Esta seguro que desea Actualizar esta informacion?";
    public static String CONFIRMA_INSERSION = "Esta seguro que desea Guardar esta informacion?";

    public static String REGISTRO_EXITOSO = "Se ha registrado la Información de manera Exitósa";

    public static String DEBE_SELECCIONAR_REGISTRO = "Debe seleccionar un registro de la tabla para poder Gestionarlo";

    public static void ErrorDesconocido(Component componente, Exception ex) {
        try {
            JOptionPane.showMessageDialog(componente,
                    "Error: " + ex.getMessage()
                    + "\nCausa: " + ex.getCause().getMessage()
                    + "\n\nFileName: " + ex.getStackTrace()[1].getFileName()
                    + "\nMethod: " + ex.getStackTrace()[1].getMethodName()
                    + "\nLineNumber: " + ex.getStackTrace()[1].getLineNumber(),
                    ERROR_INESPERADO,
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(componente,
                    "Error: " + ex.getMessage()
                    + "\n" + ex.toString()
                    + "\n\nFileName: " + ex.getStackTrace()[1].getFileName()
                    + "\nMethod: " + ex.getStackTrace()[1].getMethodName()
                    + "\nLineNumber: " + ex.getStackTrace()[1].getLineNumber(),
                    "Ocurrió un error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ErrorDesconocido(Component componente, String ex) {
        JOptionPane.showMessageDialog(componente,
                ex, ERROR_INESPERADO,
                JOptionPane.ERROR_MESSAGE);
        Dbcontext.CerrarSesion();
    }

    /*
    MENSAJES DE WALTER
     */
    public static void InformacionIncompleta(Component padre) {
        JOptionPane.showMessageDialog(padre,
                "Rellene todos los campos para continuar",
                "Información no registrada",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void InformacionIncompleta(Component padre, String CamposObligatorios) {
        JOptionPane.showMessageDialog(padre,
                "Rellene todos los campos para continuar; "
                + "Los siguientes campos son requeridos: " + CamposObligatorios,
                "Información no registrada",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void SeleccioneFila(Component padre) {
        JOptionPane.showMessageDialog(padre,
                "Seleccione un registro de la tabla",
                "Seleccione...",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void OperacionExitosa(Component padre) {
        JOptionPane.showMessageDialog(padre,
                "Se realizó la Operación de manera correcta",
                "Operación Completada",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ErrorMessage(Component padre, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(padre,
                mensaje,
                titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void WarningMessage(Component padre, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(padre,
                mensaje,
                titulo,
                JOptionPane.WARNING_MESSAGE);
    }

    public static void InfoMessage(Component padre, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(padre,
                mensaje,
                titulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static int Confirmacion(Component padre, String titulo, String mensaje) {
        return JOptionPane.showConfirmDialog(padre, mensaje,
                titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
