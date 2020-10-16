/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.RegistrosAnuladosDaoImpl;
import POJOs.Registrosanulados;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class RegistrosAnuladosBean {

    RegistrosAnuladosDaoImpl registrosDaoImpl;

    public RegistrosAnuladosBean() {
        registrosDaoImpl = new RegistrosAnuladosDaoImpl();
    }

    public List<Registrosanulados> FindAll() {
        return registrosDaoImpl.findAll();
    }

     /**
     * Retorna los Registros Anulados de Cualquier Tabla
     *
     * @param Tabla String, representa la Tabla de donde se anulo el Registro, cuando la tabla es -
     * busca todo sin realizar filtro
     * @param id int, representa el Id del registro Anulado,
     * @return Lista de Registros Anulados por Tabla.
     */
    public Registrosanulados FindById(String Tabla, int id) {
        if (Tabla.equals("-")) {
            return registrosDaoImpl.findById(id);
        } else {
            return registrosDaoImpl.findById(Tabla, id);
        }
    }

}
