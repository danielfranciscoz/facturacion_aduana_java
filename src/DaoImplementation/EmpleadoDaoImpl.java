/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Empleado;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author W4LT3R
 */
public class EmpleadoDaoImpl implements Dao<Empleado> {

    Session sf;
    Empleado empleado;
    List<Empleado> empleados;

    @Override
    public Empleado findById(int id) {
        sf = Dbcontext.IniciarSesion();
        empleado = (Empleado) sf.createCriteria(Empleado.class)
                .add(Restrictions.eq("idEmpleado",id))
                .setFetchMode("persona", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        sf = Dbcontext.IniciarSesion();
        empleados = sf.createCriteria(Empleado.class)
                .add(Restrictions.eq("regAnulado", false))
                .setFetchMode("persona", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return empleados;
    }

    public List<Empleado> findAllSinUsuario() {
        sf = Dbcontext.IniciarSesion();
        empleados = sf.createSQLQuery("SELECT * FROM Empleado WHERE IdEmpleado NOT IN "
                + "(SELECT e.IdEmpleado FROM Empleado e INNER JOIN Usuario u ON e.IdEmpleado=u.IdEmpleado);")
                .addEntity(Empleado.class)
                .list();
        Dbcontext.CerrarSesion();
        return empleados;
    }
}
