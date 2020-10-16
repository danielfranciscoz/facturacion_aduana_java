/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.ServicioAgenciaDaoImpl;
import POJOs.Serviciosagencia;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class ServicioAgenciaBean {

    ServicioAgenciaDaoImpl servicioDaoImpl;

    public ServicioAgenciaBean() {
        servicioDaoImpl = new ServicioAgenciaDaoImpl();
    }

    public List<Serviciosagencia> FindAll() {
        return servicioDaoImpl.findAll();
    }

    public Serviciosagencia FindById(int id) {
        return servicioDaoImpl.findById(id);
    }

}
