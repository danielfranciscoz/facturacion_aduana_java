package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Pantalla;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author W4LT3R
 */
public class PantallaDaoImpl implements Dao<Pantalla> {

    Session sf;
    Pantalla pantalla;
    List<Pantalla> pantallas;

    @Override
    public Pantalla findById(int id) {
        sf = Dbcontext.IniciarSesion();
        try {
            pantalla = (Pantalla) sf.createCriteria(Pantalla.class)
                    .add(Restrictions.eq("idPantalla", id))
                    .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                    .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                    .uniqueResult();
        } finally {
            Dbcontext.CerrarSesion();
        }
        return pantalla;
    }

    @Override
    public List<Pantalla> findAll() {
        sf = Dbcontext.IniciarSesion();
        try {
            pantallas = sf.createCriteria(Pantalla.class)
                    .add(Restrictions.eq("regAnulado", false))
                    .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                    .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                    .list();
        } finally {
            Dbcontext.CerrarSesion();
        }
        return pantallas;
    }

    public List<Pantalla> findByRolNoPertenecen(int idRol) {
        sf = Dbcontext.IniciarSesion();
        try {
            pantallas = sf.createSQLQuery("SELECT * FROM pantalla WHERE regAnulado=0 AND IdPantalla NOT IN\n"
                    + "(SELECT IdPantalla \n"
                    + "FROM permiso p INNER JOIN rol r\n"
                    + "ON p.IdRol=r.idRol\n"
                    + "WHERE r.idRol=" + idRol
                    + ");").addEntity(Pantalla.class).list();
        } finally {
            Dbcontext.CerrarSesion();
        }
        return pantallas;
    }
}
