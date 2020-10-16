/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.UsuarioDaoImpl;
import POJOs.Usuario;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class UsuarioBean {
     UsuarioDaoImpl usuarioDao;

    public UsuarioBean() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public Usuario FindById(String id){
        return usuarioDao.findById(id);
    }

    public Usuario FindByEmpleado(int idEmpleado){
        return usuarioDao.findByEmpleado(idEmpleado);
    }

    public List<Usuario> FindAll(){
        return usuarioDao.findAll();
    }

    public Usuario UsuarioValido(String User, String Pass){
        return usuarioDao.UsuarioValido(User, Pass);
    }


}