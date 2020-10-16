/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Permiso;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author W4LT3R
 */
public class PermisoDaoImpl implements Dao<Permiso> {

    Session sf;
    Permiso permiso;
    List<Permiso> permisos;

    @Override
    public Permiso findById(int id) {
        sf = Dbcontext.IniciarSesion();
        permiso = (Permiso) sf.createCriteria(Permiso.class)
                .add(Restrictions.eq("id", id))
                .setFetchMode("pantalla", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return permiso;
    }

    @Override
    public List<Permiso> findAll() {
        sf = Dbcontext.IniciarSesion();
        permisos = sf.createCriteria(Permiso.class)
                .add(Restrictions.eq("regAnulado", false))
                .setFetchMode("pantalla", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return permisos;
    }

    public List<Permiso> findByRol(int id) {
        sf = Dbcontext.IniciarSesion();
        permisos = sf.createCriteria(Permiso.class)
                .add(Restrictions.eq("rol.idRol", id))
                .setFetchMode("pantalla", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return permisos;
    }
}
