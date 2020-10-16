/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.PermisoDaoImpl;
import POJOs.Permiso;
import java.util.List;

/**
 *
 * @author W4LT3R
 */
public class PermisoBean {
    PermisoDaoImpl permisoDao = new PermisoDaoImpl();

    public Permiso FindById(){
        return null;
    }

    public List<Permiso> FindByRol(int id){
        return permisoDao.findByRol(id);
    }
}