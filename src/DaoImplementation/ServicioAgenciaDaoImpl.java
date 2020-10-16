/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Serviciosagencia;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class ServicioAgenciaDaoImpl implements Dao<Serviciosagencia> {

    Session sf;
    Serviciosagencia servicio;
    List<Serviciosagencia> servicios;

    @Override
    public Serviciosagencia findById(int id) {
        sf = Dbcontext.IniciarSesion();
        servicio = (Serviciosagencia) sf.createCriteria(Serviciosagencia.class)
                .add(Restrictions.eq("cuentaRegistro", id))
                .setFetchMode("factura", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return servicio;
    }

    @Override
    public List<Serviciosagencia> findAll() {
        sf = Dbcontext.IniciarSesion();
        servicios = (ArrayList<Serviciosagencia>) sf.createQuery("from ServiciosAgencia sa JOIN FETCH sa.factura f").list();
        Dbcontext.CerrarSesion();
        return servicios;
    }

}
