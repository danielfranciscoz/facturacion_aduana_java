package Utilidad;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author W4LT3R
 */
public class UtilDate {

    public static String CurrentDate() {
        return new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy").format(new Date());
    }

    public static String DateNicaraguaFecha(Date fecha) {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("d-MMM-yyyy");
            return formateador.format(fecha);
        } catch (NullPointerException ex) {
            return "--";
        }
    }

    public static String DateNicaraguaHora(Date fecha) {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("hh:mm a");
            return formateador.format(fecha);
        } catch (NullPointerException ex) {
            return "--";
        }
    }

    public static String DateFullNicaragua(Date fecha) {
        try {
            SimpleDateFormat formatear = new SimpleDateFormat("d-MMM-yyyy hh:mm a");
            return formatear.format(fecha);
        } catch (NullPointerException ex) {
            return "--";
        }
    }

    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    public static synchronized java.util.Date stringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*Metodo que obtiene la fecha con el formato para MySQL */
    public static Date FechaMySQL() {
        Timestamp time = new Timestamp(new Date().getTime());
        return time;
    }

    public static String FechaMySQL(Date fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        return formatoDelTexto.format(fecha);
    }

    public static String MesFromInteger(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes - 1];
    }

    public static int IntegerFromMes(String mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int IntMes = 0;
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(mes)) {
                IntMes = i + 1;
                break;
            }
        }
        return IntMes;
    }

    public static String MesActual() {
        String IntMes = "1";
        IntMes = MesFromInteger(Calendar.getInstance().get(Calendar.MONTH) + 1);
        return IntMes;
    }
    
    public static int AñoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
