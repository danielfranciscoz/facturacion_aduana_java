/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Detallenotadebito;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class DetalleNotaDebitoDaoImpl implements Dao<Detallenotadebito> {

    Session sf;
    Detallenotadebito detalle;
    List<Detallenotadebito> detalles;

    @Override
    public Detallenotadebito findById(int id) {
        sf = Dbcontext.IniciarSesion();
        detalle = (Detallenotadebito) sf.createCriteria(Detallenotadebito.class)
                .add(Restrictions.eq("idDetalleNotaDebito",  id))
                .setFetchMode("notadebito", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return detalle;
    }

    @Override
    public List<Detallenotadebito> findAll() {
        sf = Dbcontext.IniciarSesion();
        detalles = (List<Detallenotadebito>) sf.createQuery("from Detallenotadebito d JOIN FETCH d.notadebito n JOIN FETCH d.usuarioByUserCreacion uuc JOIN FETCH d.usuarioByUserModificacion uum").list();
        Dbcontext.CerrarSesion();
        return detalles;
    }

    public List<Detallenotadebito> findAll(int NotaDebito) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Detallenotadebito d JOIN FETCH d.notadebito n JOIN FETCH d.usuarioByUserCreacion uuc JOIN FETCH d.usuarioByUserModificacion uum where n.notaDebito =:id");
        query.setInteger("id", NotaDebito);
        detalles = (List<Detallenotadebito>) query.list();
        Dbcontext.CerrarSesion();
        return detalles;
    }
}
