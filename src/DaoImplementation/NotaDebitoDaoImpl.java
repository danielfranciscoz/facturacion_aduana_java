/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Notadebito;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author Daniel-Zamora
 */
public class NotaDebitoDaoImpl implements Dao<Notadebito> {

    Session sf;
    Notadebito nota;
    List<Notadebito> notas;

    @Override
    public Notadebito findById(int id) {
        sf = Dbcontext.IniciarSesion();
        nota = (Notadebito) sf.createCriteria(Notadebito.class)
                .add(Restrictions.eq("notaDebito", id))
                .setFetchMode("cliente", FetchMode.JOIN)
                .setFetchMode("factura", FetchMode.JOIN)
                .setFetchMode("usuarioByUserImpresion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .uniqueResult();
        return nota;
    }

    @Override
    public List<Notadebito> findAll() {
        sf = Dbcontext.IniciarSesion();
        notas = (List<Notadebito>) sf.createQuery("from Notadebito n LEFT JOIN FETCH n.factura f LEFT JOIN FETCH n.cliente c LEFT JOIN FETCH n.usuarioByUserImpresion uui JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum  order by year(n.fechaCreacion) DESC, month(n.fechaCreacion) DESC").list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAll(String Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n LEFT JOIN FETCH n.factura f LEFT JOIN FETCH n.cliente c LEFT JOIN FETCH n.usuarioByUserImpresion uui JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where year(n.fechaCreacion) =:anio order by year(n.fechaCreacion) DESC, month(n.fechaCreacion) DESC");
        query.setString("anio", Anio);
        notas = (ArrayList<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAll(int Mes, String Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n LEFT JOIN FETCH n.factura f LEFT JOIN FETCH n.cliente c LEFT JOIN FETCH n.usuarioByUserImpresion uui JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where month(n.fechaCreacion) =:mes AND year(n.fechaCreacion) =:anio order by year(n.fechaCreacion) DESC, month(n.fechaCreacion) DESC");
        query.setInteger("mes", Mes);
        query.setString("anio", Anio);
        notas = (ArrayList<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAll(int CuentaRegistro) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.factura f JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum LEFT JOIN FETCH n.usuarioByUserImpresion uui where n.factura.cuentaRegistro=:Id");
        query.setParameter("Id", CuentaRegistro);
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findRangoFechas(Date FechaInicio, Date FechaFin) {
        sf = Dbcontext.IniciarSesion();
        notas = sf.createCriteria(Notadebito.class)
                .add(Restrictions.between("fechaCreacion", FechaInicio, FechaFin))
                .createAlias("cliente","cliente", JoinType.LEFT_OUTER_JOIN)
                .createAlias("factura","factura", JoinType.LEFT_OUTER_JOIN)
                .createAlias("usuarioByUserImpresion","usuarioByUserImpresion", JoinType.LEFT_OUTER_JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .addOrder(Order.desc("fechaCreacion"))
                .list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAllCiente(int IdCliente) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.cliente c JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where n.cliente.idCliente=:Id AND n.factura.cuentaRegistro is null");
        query.setParameter("Id", IdCliente);
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAllCiente() {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.cliente c JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum ");
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAllCiente(String Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.cliente c JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where YEAR(n.fechaCreacion) = :Anio");
        query.setParameter("Anio", Integer.parseInt(Anio));
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAllCiente(int Mes, int Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.cliente c JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where YEAR(n.fechaCreacion) = :Anio AND MONTH(n.fechaCreacion) = :Mes");
        query.setParameter("Anio", Anio);
        query.setParameter("Mes", Mes);
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public List<Notadebito> findAllCienteByRangoFecha(Date FechaInicio, Date FechaFin) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Notadebito n JOIN FETCH n.cliente c JOIN FETCH n.usuarioByUserCreacion uuc JOIN FETCH n.usuarioByUserModificacion uum where  n.fechaCreacion >= :Inicio AND n.fechaCreacion <= :Fin");
        query.setParameter("Inicio", FechaInicio);
        query.setParameter("Fin", FechaFin);
        notas = (List<Notadebito>) query.list();
        Dbcontext.CerrarSesion();
        return notas;
    }

    public int findMayorID() {
        sf = Dbcontext.IniciarSesion();
        Criteria criteria = sf
                .createCriteria(Notadebito.class)
                .setProjection(Projections.max("notaDebito"));
        Integer LastID = 0;
        if (criteria.uniqueResult() != null) {
            LastID = (Integer) criteria.uniqueResult();
        }
        Dbcontext.CerrarSesion();
        return LastID;
    }

    public List<Integer> findMeses() {
        List<Integer> Meses;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select month(n.fechaCreacion) from Notadebito n where n.fechaCreacion is not null group by month(n.fechaCreacion) order by month(n.fechaCreacion) desc");
        Meses = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Meses;
    }

    public List<Integer> findAnios() {
        List<Integer> Meses;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select year(n.fechaCreacion) from Notadebito n where n.fechaCreacion is not null group by year(n.fechaCreacion) order by year(n.fechaCreacion) desc");
        Meses = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Meses;
    }
}
