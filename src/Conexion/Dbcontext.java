package Conexion;

import java.sql.Connection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Daniel Zamora
 */
public class Dbcontext {

    static Configuration con;
    static SessionFactory factor;
    static Session sesion;
    static Connection conexion;
    static ArchivoConfiguracion SavedConf;
    static Transaction tx;

    /*Este constructor es para crear la conexion con los valores almacenados en al Archivo de Conf.*/
    public Dbcontext() throws Exception {
        SavedConf = new ArchivoConfiguracion();
        con = new Configuration().configure("/Conexion/hibernate.cfg.xml");
        con.setProperty("hibernate.connection.url", "jdbc:mysql://" + SavedConf.ReadIP() + ":" + SavedConf.ReadPuerto() + "/" + SavedConf.ReadDB());
        con.setProperty("hibernate.connection.username", SavedConf.ReadUser());
        con.setProperty("hibernate.connection.password", Utilidad.Cifrado.decrypt(SavedConf.ReadPass()));
        con.setProperty("hibernate.connection.autocommit", "true");
//        con.setProperty("hibernate.transaction.auto_close_session", "true");
//        con.setProperty("hibernate.connection.release_mode", "on_close");
        StartSessionFactory();
    }

    /*Este constructor es para probar la conexion*/
    public Dbcontext(String DB, String Usuario, String Pass, String Puerto, String IP) {
        con = new Configuration().configure("/Conexion/hibernate.cfg.xml");
        con.setProperty("hibernate.connection.url", "jdbc:mysql://" + IP + ":" + Puerto + "/" + DB + "?zeroDateTimeBehavior=convertToNull");
        con.setProperty("hibernate.connection.username", Usuario);
        con.setProperty("hibernate.connection.password", Pass);
        con.setProperty("hibernate.connection.autocommit", "true");
//        con.setProperty("hibernate.transaction.auto_close_session", "true");
//        con.setProperty("hibernate.connection.release_mode", "on_close");
        StartSessionFactory();
    }

    private static void StartSessionFactory() {
        try {
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
            factor = con.buildSessionFactory(ssrb.build());
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }

//    public static Connection getConnection() throws SQLException {
//        SessionFactoryImplementor sfi = (SessionFactoryImplementor) factor;
//        conexion = (Connection) sfi.getConnectionProvider().getConnection();
//        return conexion;
//    }
    public static synchronized Session IniciarSesion() {
        sesion = factor.openSession();
        return sesion;
    }

    public static synchronized void CerrarSesion() {
        sesion.close();
    }

    /*Metodos de Gestion de Informacion*/
    public static synchronized void guardar(Object obj) {
        tx = IniciarSesion().beginTransaction();
        sesion.save(obj);
        tx.commit();
        sesion.close();
    }

    public static synchronized void actualizar(Object obj) {
        tx = IniciarSesion().beginTransaction();
//        sesion.update(obj); Comentariado en la creacion de la version 2.0 debido a problema con las sessiones abiertas, la investigacion indica que el uso de Merge es mejor que update
sesion.merge(obj);
        tx.commit();
        sesion.close();
    }

    public static synchronized void eliminar(Object obj) {
        tx = IniciarSesion().beginTransaction();
        sesion.delete(obj);
        tx.commit();
        sesion.close();
    }

    public static synchronized void guardarOrActualizar(Object obj) {
        tx = IniciarSesion().beginTransaction();
        sesion.saveOrUpdate(obj);
        tx.commit();
        sesion.close();
    }
}
