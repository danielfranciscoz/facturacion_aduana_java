/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Recibo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Daniel
 */
public class ReciboDaoImpl implements Dao<Recibo> {

    Session sf;
    List<Recibo> recibos;

    @Override
    public Recibo findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recibo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Recibo> findAll(int IdCliente) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Recibo where IdCliente=:Id");
        query.setParameter("Id", IdCliente);
        recibos = (List<Recibo>) query.list();
        Dbcontext.CerrarSesion();
        return recibos;
    }

    public List<Recibo> findAll(int IdCliente, int Mes, int Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = null;
        if (IdCliente != -1) {
            query = sf.createQuery("from Recibo where IdCliente=:Id and (month(fechaCreacion) =:mes AND year(fechaCreacion) =:anio)");
            query.setParameter("Id", IdCliente);
        } else {
            query = sf.createQuery("from Recibo where (month(fechaCreacion) =:mes AND year(fechaCreacion) =:anio)");
        }
        query.setParameter("mes", Mes);
        query.setParameter("anio", Anio);
        recibos = (List<Recibo>) query.list();
        Dbcontext.CerrarSesion();
        return recibos;
    }

    public List<Integer> findMeses() {
        List<Integer> Meses;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select month(f.fechaCreacion) from Recibo f where f.fechaCreacion is not null group by month(f.fechaCreacion) order by month(f.fechaCreacion) desc");
        Meses = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Meses;
    }

    public List<Integer> findAnios() {
        List<Integer> Anios;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select year(f.fechaCreacion) from Recibo f where f.fechaCreacion is not null group by year(f.fechaCreacion) order by year(f.fechaCreacion) desc");
        Anios = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Anios;
    }

    public int findMayorID() {
        sf = Dbcontext.IniciarSesion();
        Criteria criteria = sf
                .createCriteria(Recibo.class)
                .setProjection(Projections.max("noRecibo"));
        Integer LastID = (Integer) criteria.uniqueResult();
        Dbcontext.CerrarSesion();
        return LastID;
    }
}
