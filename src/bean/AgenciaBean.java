/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.AgenciaDaoImpl;
import POJOs.Agencia;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class AgenciaBean {

    AgenciaDaoImpl agenciaMedidaDaoImpl;

    public AgenciaBean() {
        agenciaMedidaDaoImpl = new AgenciaDaoImpl();
    }

    public Agencia FindById(int id) {
        return agenciaMedidaDaoImpl.findById(id);
    }

    /**
     * Retorna los registros activos si se va a guardar, y Registros Activos y
     * Anulados si se va a Modificar
     *
     * @param ObjetivoCarga boolean, true = Guardar, false = Modificar
     * @return Lista de Agencias en dependencia del Objetivo.
     */
    public List<Agencia> FindAll(boolean ObjetivoCarga) {
        if (ObjetivoCarga) {
        return agenciaMedidaDaoImpl.findAll();    
        }else{
        return agenciaMedidaDaoImpl.findAll_WithAnulados();    
        }
        
    }
}
