/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Factura;
import POJOs.Persona;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author W4LT3R
 */
public class PersonaDaoImpl implements Dao<Persona> {

    Session sf;
    Persona persona;
    List<Persona> personas;

    @Override
    public Persona findById(int id) {
        sf = Dbcontext.IniciarSesion();
        persona = (Persona) sf.createCriteria(Persona.class)
                .add(Restrictions.eq("idPersona", id))
                .setFetchMode("empleado", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return persona;
    }

    @Override
    public List<Persona> findAll() {
        return null;
    }

    public int MaxID(){
        sf = Dbcontext.IniciarSesion();
        Criteria criteria = sf.createCriteria(Persona.class).setProjection(Projections.max("idPersona"));
        Integer LastID = (Integer) criteria.uniqueResult();
        Dbcontext.CerrarSesion();
        return LastID;
    }
}
