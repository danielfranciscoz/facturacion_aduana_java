/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.PersonaDaoImpl;
import POJOs.Persona;

/**
 *
 * @author W4LT3R
 */
public class PersonaBean {
    PersonaDaoImpl pdi;

    public PersonaBean() {
        pdi = new PersonaDaoImpl();
    }

    public Persona FindById(int id){
        return pdi.findById(id);
    }

    public int MaxId(){
        return pdi.MaxID();
    }
}
