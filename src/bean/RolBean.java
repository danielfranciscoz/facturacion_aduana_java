/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.RolDaoImpl;
import POJOs.Rol;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class RolBean {
     RolDaoImpl rolDao;
  
    public RolBean() {
        rolDao = new RolDaoImpl();
    }

    public Rol FindById(int id){
        return rolDao.findById(id);
    }
    public List<Rol> FindAll(){
        return rolDao.findAll();
    }
}
