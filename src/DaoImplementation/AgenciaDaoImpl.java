/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Agencia;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class AgenciaDaoImpl implements Dao<Agencia> {

    Session sf;
    Agencia agencia;
    List<Agencia> agencias;

    @Override
    public Agencia findById(int id) {
        sf = Dbcontext.IniciarSesion();
        agencia = (Agencia) sf.createCriteria(Agencia.class)
                .add(Restrictions.eq("idAgencia", id))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return agencia;
    }

    @Override
    public List<Agencia> findAll() {
        sf = Dbcontext.IniciarSesion();
        agencias = sf.createCriteria(Agencia.class)
                .add(Restrictions.eq("regAnulado", false))
                .addOrder(Order.asc("nombre"))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
//        agencias = (ArrayList<Agencia>) sf.createQuery("from Agencia where RegAnulado=0").list();
        return agencias;
    }

    public List<Agencia> findAll_WithAnulados() {
        sf = Dbcontext.IniciarSesion();
        agencias = sf.createCriteria(Agencia.class)
                .addOrder(Order.asc("nombre"))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return agencias;
    }
}
