/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

/**
 *
 * @author W4LT3R
 */
public class UtilString {
    /*Metodo que recibe una cadeba de Texto, si se encuentra vacia retorna "--"*/
    public static String EvitaVacio(String Cadena) {
        if (Cadena == null || Cadena.isEmpty()) {
            return "--";
        } else {
            return Cadena;
        }
    }

    public static boolean isNullOrEmpty(String cadena) {
        try {
            return cadena.isEmpty();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public static boolean contiene(String cadena, String filtro) {
        try {
            return cadena.toUpperCase().contains(filtro.toUpperCase());
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public static String union(String[] values) {
        String resultado = "";
        for (String value : values) {
            if (value != null) {
                resultado += value.trim() + " ";
            }
        }
        return resultado;
    }
}
