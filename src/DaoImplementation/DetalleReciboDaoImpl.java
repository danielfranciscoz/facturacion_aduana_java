/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Detallerecibo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Daniel-Zamora
 */
public class DetalleReciboDaoImpl implements Dao<Detallerecibo> {

    Session sf;
    List<Detallerecibo> recibos;

    @Override
    public Detallerecibo findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detallerecibo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double MontoRecibo(int IdRecibo) {
        double Monto = 0.00;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("SELECT sum(monto) from Detallerecibo where idRecibo =:NoRecibo");
        query.setParameter("NoRecibo", IdRecibo);
        Monto = Double.parseDouble(query.uniqueResult().toString());
        Dbcontext.CerrarSesion();
        return Monto;
    }

    public List<Detallerecibo> findAll(int IdRecibo) {
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Detallerecibo where idRecibo =:NoRecibo");
        query.setParameter("NoRecibo", IdRecibo);
        recibos = (List<Detallerecibo>) query.list();
        Dbcontext.CerrarSesion();
        return recibos;
    }

    public double MontoPagadoFactura(int IdRegistro) {
        double Monto;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("SELECT sum(monto) from Detallerecibo where factura.cuentaRegistro =:IdRegistro");
        query.setParameter("IdRegistro", IdRegistro);
        try {
            Monto = Double.parseDouble(query.uniqueResult().toString());
        } catch (NullPointerException e) {
            Monto = 0.00;
        }
        Dbcontext.CerrarSesion();
        return Monto;
    }

    public double MontoPagadoNotaDebito(int IdRegistro) {
        double Monto = 0.00;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("SELECT sum(monto) from Detallerecibo where notadebito.notaDebito =:IdRegistro");
        query.setParameter("IdRegistro", IdRegistro);
        try {
            Monto = Double.parseDouble(query.uniqueResult().toString());
        } catch (NullPointerException e) {
            Monto = 0.00;
        }
        Dbcontext.CerrarSesion();
        return Monto;
    }

    public int findByCuentaRegistro(int IdCuentaRegistro) {
        int CantidadElementos = 0;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Detallerecibo where factura.cuentaRegistro=:Id");
        query.setParameter("Id", IdCuentaRegistro);
        CantidadElementos = query.list().size();
        Dbcontext.CerrarSesion();
        return CantidadElementos;
    }

    public int findByNotaDebito(int IdNotaDebito) {
        int CantidadElementos = 0;
        sf = Dbcontext.IniciarSesion();
        Query query = sf.createQuery("from Detallerecibo where notadebito.notaDebito=:Id");
        query.setParameter("Id", IdNotaDebito);
        CantidadElementos = query.list().size();
        Dbcontext.CerrarSesion();
        return CantidadElementos;
    }
}
