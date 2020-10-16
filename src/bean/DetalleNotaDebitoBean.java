/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.DetalleNotaDebitoDaoImpl;
import POJOs.Detallenotadebito;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class DetalleNotaDebitoBean{

    DetalleNotaDebitoDaoImpl detalleDaoImpl;

    public DetalleNotaDebitoBean() {
        detalleDaoImpl = new DetalleNotaDebitoDaoImpl();
    }

    public List<Detallenotadebito> FindAll(int NotaDebito) {
        return detalleDaoImpl.findAll(NotaDebito);
    }

    public Detallenotadebito FindById(int id) {
        return detalleDaoImpl.findById(id);
    }

}
