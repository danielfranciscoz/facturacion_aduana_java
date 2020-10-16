/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.EmpleadoDaoImpl;
import POJOs.Empleado;
import java.util.List;

/**
 *
 * @author W4LT3R
 */
public class EmpleadoBean {

    EmpleadoDaoImpl edi = new EmpleadoDaoImpl();

    public Empleado FindById(int id){
        return edi.findById(id);
    }

    public List<Empleado> FindAll(){
        return edi.findAll();
    }

    public List<Empleado> FindAllSinUsuario(){
        return edi.findAllSinUsuario();
    }

}
