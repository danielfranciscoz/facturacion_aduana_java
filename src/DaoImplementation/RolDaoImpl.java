/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Rol;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class RolDaoImpl implements Dao<Rol> {

    Session sf;
    Rol rol;
    List<Rol> roles;

    @Override
    public Rol findById(int id) {
        sf = Dbcontext.IniciarSesion();
        try {
            rol = (Rol) sf.createCriteria(Rol.class)
                    .add(Restrictions.eq("idRol", id))
                    .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                    .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN).uniqueResult();
        } finally {
            Dbcontext.CerrarSesion();
        }
        return rol;
    }

    @Override
    public List<Rol> findAll() {
        sf = Dbcontext.IniciarSesion();
        try {
            roles = sf.createCriteria(Rol.class)
                    .add(Restrictions.eq("regAnulado", false))
                    .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                    .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                    .list();
        } finally {
            Dbcontext.CerrarSesion();
        }
        return roles;
    }
}
