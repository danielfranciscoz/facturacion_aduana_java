package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Registrosanulados;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class RegistrosAnuladosDaoImpl implements Dao<Registrosanulados> {

    Session sf;

    Registrosanulados registroAnulado;
    List<Registrosanulados> registrosAnulados;

    @Override
    public Registrosanulados findById(int id) {
        sf = Dbcontext.IniciarSesion();
        registroAnulado = (Registrosanulados) sf.createCriteria(Registrosanulados.class)
                .add(Restrictions.eq("idRegistrosAnulados", id))
                .setFetchMode("usuario", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return registroAnulado;
    }

    @Override
    public List<Registrosanulados> findAll() {
        sf = Dbcontext.IniciarSesion();
        registrosAnulados = sf.createCriteria(Registrosanulados.class)
                .setFetchMode("usuario", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return registrosAnulados;
    }

    public Registrosanulados findById(String Tabla, int Id) {
        sf = Dbcontext.IniciarSesion();
        registroAnulado = (Registrosanulados) sf.createCriteria(Registrosanulados.class)
                .add(Restrictions.eq("tabla", Tabla))
                .add(Restrictions.eq("idRegistro", Id))
                .setFetchMode("usuario", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return registroAnulado;
    }
}
