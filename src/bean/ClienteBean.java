/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.ClienteDaoImpl;
import POJOs.Cliente;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class ClienteBean {

    ClienteDaoImpl clienteDao;
    Cliente cliente;

    public ClienteBean() {
        clienteDao = new ClienteDaoImpl();
        cliente = new Cliente();
    }

    public Cliente FindById(int id) {
        return clienteDao.findById(id);
    }

    /**
     * Retorna los registros activos si se va a guardar, y Registros Activos y
     * Anulados si se va a Modificar
     *
     * @param ObjetivoCarga boolean, true = Guardar, false = Modificar
     * @return Lista de Clientes en dependencia del Objetivo.
     */
    public List<Cliente> FindAll(boolean ObjetivoCarga) {
        if (ObjetivoCarga) {
            return clienteDao.findAll();
        } else {
            return clienteDao.findAll_WithAnualdos();
        }
    }
    
}
