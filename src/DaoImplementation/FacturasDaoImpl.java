package DaoImplementation;

import Conexion.Dbcontext;
import POJOs.Factura;
import java.util.List;
import org.hibernate.Session;
import DaoInterface.Dao;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class FacturasDaoImpl implements Dao<Factura> {

    Session sf;
    Factura factura;
    List<Factura> facturas;

    @Override
    public Factura findById(int id) {
        sf = Dbcontext.IniciarSesion();
        factura = (Factura) sf.createCriteria(Factura.class)
                .add(Restrictions.eq("cuentaRegistro", id))
                .setFetchMode("agencia", FetchMode.JOIN)
                .setFetchMode("cliente", FetchMode.JOIN)
                .setFetchMode("producto", FetchMode.JOIN)
                .setFetchMode("usuarioByUserImpresion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return factura;
    }

    @Override
    public List<Factura> findAll() {
        sf = Dbcontext.IniciarSesion();
        facturas = sf.createCriteria(Factura.class)
                .setFetchMode("agencia", FetchMode.JOIN)
                .setFetchMode("cliente", FetchMode.JOIN)
                .setFetchMode("producto", FetchMode.JOIN)
                .setFetchMode("usuarioByUserImpresion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .addOrder(Order.desc("cuentaRegistro"))
                .list();
        Dbcontext.CerrarSesion();
//        ArrayList<Factura> facturas;
//        facturas = (ArrayList<Factura>) sf.createQuery("from Factura order by CuentaRegistro DESC").list();
//        return facturas;
        return facturas;
    }

    public List<Factura> findAll(int Mes, int Anio) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Factura f "
                + "JOIN FETCH f.agencia a JOIN FETCH f.producto p  JOIN FETCH f.cliente c JOIN FETCH f.usuarioByUserCreacion uuc JOIN FETCH f.usuarioByUserModificacion uum "
                + "LEFT JOIN FETCH f.usuarioByUserImpresion uui "
                + "where month(f.fechaCreacion) =:mes AND year(f.fechaCreacion) =:anio order by f.cuentaRegistro DESC");
        query.setInteger("mes", Mes);
        query.setInteger("anio", Anio);
        facturas = (ArrayList<Factura>) query.list();
        Dbcontext.CerrarSesion();
        return facturas;
    }

    public List<Factura> findClientesFacturas(int IdCliente) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Factura f "
                + "JOIN FETCH f.agencia a JOIN FETCH f.cliente c JOIN FETCH f.producto p "
                + "JOIN FETCH f.usuarioByUserImpresion uui JOIN FETCH f.usuarioByUserCreacion uuc JOIN FETCH f.usuarioByUserModificacion uum "
                + " where c.idCliente =:idCliente order by f.cuentaRegistro DESC");
        query.setInteger("idCliente", IdCliente);
        facturas = (ArrayList<Factura>) query.list();
        Dbcontext.CerrarSesion();
        return facturas;
    }

    public List<Factura> findAll(int Anio) {
        sf = Dbcontext.IniciarSesion();

        Query query = sf.createQuery("from Factura f "
                + "JOIN FETCH f.agencia a JOIN FETCH f.cliente c JOIN FETCH f.producto p "
                + "JOIN FETCH f.usuarioByUserImpresion uui JOIN FETCH f.usuarioByUserCreacion uuc JOIN FETCH f.usuarioByUserModificacion uum "
                + " where year(f.fechaCreacion) =:anio order by f.cuentaRegistro DESC");
        query.setInteger("anio", Anio);
        facturas = (ArrayList<Factura>) query.list();
        Dbcontext.CerrarSesion();
        return facturas;
    }

    public int findMayorID() {
        sf = Dbcontext.IniciarSesion();
        Criteria criteria = sf
                .createCriteria(Factura.class)
                .setProjection(Projections.max("cuentaRegistro"));
        Integer LastID = (Integer) criteria.uniqueResult();
        Dbcontext.CerrarSesion();
        return LastID;
    }

    public List<Integer> findMeses() {
        List<Integer> Meses;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select month(f.fechaCreacion) from Factura f where f.fechaCreacion is not null group by month(f.fechaCreacion) order by month(f.fechaCreacion) desc");
        Meses = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Meses;
    }

    public List<Integer> findAnios() {
        List<Integer> Anios;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("select year(f.fechaCreacion) from Factura f where f.fechaCreacion is not null group by year(f.fechaCreacion) order by year(f.fechaCreacion) desc");
        Anios = (ArrayList<Integer>) query.list();
        Dbcontext.CerrarSesion();
        return Anios;
    }

    public List<Factura> findRangoFechas(Date FechaInicio, Date FechaFin) {
        sf = Dbcontext.IniciarSesion();
        facturas = sf.createCriteria(Factura.class)
                .setFetchMode("agencia", FetchMode.JOIN)
                .setFetchMode("cliente", FetchMode.JOIN)
                .setFetchMode("producto", FetchMode.JOIN)
                .setFetchMode("usuarioByUserImpresion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .add(Restrictions.between("fechaCreacion", FechaInicio, FechaFin))
                .addOrder(Order.desc("cuentaRegistro"))
                .list();
//        Query query = sf.createQuery("from Factura f where (DATE(f.fechaCreacion) >=:fechaInicial AND DATE(f.fechaCreacion) <=:fechaFinal) order by f.fechaCreacion desc");
//        query.setString("fechaInicial", FechaInicio.toString());
//        query.setString("fechaFinal", FechaFin.toString());
//        facturas = (ArrayList<Factura>) query.list();
        Dbcontext.CerrarSesion();
        return facturas;
    }

}
