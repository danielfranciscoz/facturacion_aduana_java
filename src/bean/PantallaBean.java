package bean;

import DaoImplementation.PantallaDaoImpl;
import POJOs.Pantalla;
import java.util.List;

public class PantallaBean {

    PantallaDaoImpl pdi = new PantallaDaoImpl();

    public synchronized Pantalla FindById(int id){
        return pdi.findById(id);
    }

    public synchronized List<Pantalla> FindAll(){
        return pdi.findAll();
    }

    public synchronized List<Pantalla> FindByRolNoPertenecen(int idRol){
        return pdi.findByRolNoPertenecen(idRol);
    }
}