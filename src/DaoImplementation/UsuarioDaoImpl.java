/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Usuario;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class UsuarioDaoImpl implements Dao<Usuario> {

    Session sf;
    Usuario usuario;
    List<Usuario> usuarios;

    @Override
    public Usuario findById(int id) {
        sf = Dbcontext.IniciarSesion();
        usuario = (Usuario) sf.createCriteria(Usuario.class)
                .add(Restrictions.ge("idUsuario", id))
                .setFetchMode("empleado", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN).list().get(0);
        Dbcontext.CerrarSesion();
        return usuario;
    }

    public Usuario findById(String id) {
        sf = Dbcontext.IniciarSesion();
        usuario = (Usuario) sf.createCriteria(Usuario.class)
                .add(Restrictions.eq("idUsuario", id))
                .setFetchMode("empleado", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return usuario;
    }

    public Usuario findByEmpleado(int idEmpleado) {
        sf = Dbcontext.IniciarSesion();
        usuario = (Usuario) sf.createCriteria(Usuario.class)
                .add(Restrictions.eq("empleado.idEmpleado", idEmpleado))
                .setFetchMode("empleado", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        sf = Dbcontext.IniciarSesion();
        usuarios = sf.createCriteria(Usuario.class)
                .setFetchMode("empleado", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .list();

//select distinct c from Campaign c join fetch c.subcampaigns s join fetch s.budgets
//        
//        Query query = sf.createQuery("from Usuario u join fetch u.empleado e ");
//        usuarios = query.list();
        Dbcontext.CerrarSesion();
        return usuarios;
    }

    public Usuario UsuarioValido(String User, String Password) {
        sf = Dbcontext.IniciarSesion();
        usuario = (Usuario) sf.createCriteria(Usuario.class)
                .add(Restrictions.eq("idUsuario", User))
                .add(Restrictions.eq("password", Password))
                .setFetchMode("empleado", FetchMode.JOIN)
                .setFetchMode("rol", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .uniqueResult();
//        Query query = sf.createQuery("from Usuario where idUsuario =:user AND Password =:pass");
//        query.setString("user", User);
//        query.setString("pass", Password);
        Dbcontext.CerrarSesion();
        return usuario;
    }

}
