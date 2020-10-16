package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Zamora
 */
public class ArchivoConfiguracion {

    File recordar;
    File directorio = new File(System.getProperty("user.home") + "\\AppData\\Local\\TechBrain\\SIAA");

    public ArchivoConfiguracion() throws IOException {

        if (System.getProperty("os.name").contains("Mac OS")) {
            recordar = new File("conf.cfg");
        } else {

            recordar = new File(System.getProperty("user.home") + "\\AppData\\Local\\TechBrain\\SIAA\\conf.cfg");
            directorio.mkdirs();
        }

        if (!recordar.exists()) {
            recordar.createNewFile();
            IniciarValoresPorFefecto();
        }
    }

    public void RecordarConexion(String db, String user, String pass, String puerto, String ip) {
        try {
            FileOutputStream fos;
            Properties proper = new Properties();
            fos = new FileOutputStream(recordar, false);

            proper.setProperty("ip", ip);
            proper.setProperty("port", puerto);
            proper.setProperty("user", user);
            proper.setProperty("pass", pass);
            proper.setProperty("db", db);
            proper.store(fos, null);
            fos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public String ReadIP() {
        try {
            String host;
            FileInputStream fis;

            fis = new FileInputStream(recordar);
            Properties pro = new Properties();
            pro.load(fis);

            host = pro.getProperty("ip");
            fis.close();
            return host;

        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String ReadPuerto() {
        try {
            String puerto;
            FileInputStream fis;

            fis = new FileInputStream(recordar);
            Properties pro = new Properties();
            pro.load(fis);

            puerto = pro.getProperty("port");

            fis.close();
            return puerto;

        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String ReadUser() {
        try {
            String puerto;
            FileInputStream fis;

            fis = new FileInputStream(recordar);
            Properties pro = new Properties();
            pro.load(fis);

            puerto = pro.getProperty("user");

            fis.close();
            return puerto;

        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String ReadPass() {
        try {
            String puerto;
            FileInputStream fis;

            fis = new FileInputStream(recordar);
            Properties pro = new Properties();
            pro.load(fis);

            puerto = pro.getProperty("pass");

            fis.close();
            return puerto;

        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String ReadDB() {
        try {
            String puerto;
            FileInputStream fis;

            fis = new FileInputStream(recordar);
            Properties pro = new Properties();
            pro.load(fis);

            puerto = pro.getProperty("db");

            fis.close();
            return puerto;

        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    private void IniciarValoresPorFefecto() {
        try {
            FileOutputStream fos;
            Properties proper = new Properties();
            fos = new FileOutputStream(recordar, false);

            proper.setProperty("ip", "127.0.0.1");
            proper.setProperty("port", "3306");
            proper.setProperty("user", "root");
            proper.setProperty("pass", "");
            proper.setProperty("db", "AgenciaAduanera");
            proper.store(fos, null);
            fos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
