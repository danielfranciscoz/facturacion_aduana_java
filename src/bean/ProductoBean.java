/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.ProductoDaoImpl;
import POJOs.Producto;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class ProductoBean {

    ProductoDaoImpl productoDao;

    public ProductoBean() {
        productoDao = new ProductoDaoImpl();
    }

    public Producto FindById(int id) {
        return productoDao.findById(id);
    }

    /**
     * Retorna los registros activos si se va a guardar, y Registros Activos y
     * Anulados si se va a Modificar
     *
     * @param ObjetivoCarga boolean, true = Guardar, false = Modificar
     * @return Lista de productos en dependencia del Objetivo.
     */
    public List<Producto> FindAll(boolean ObjetivoCarga) {
        if (ObjetivoCarga) {
            return productoDao.findAll();
        } else {
            return productoDao.findAll_WithAnulados();
        }

    }
}
