/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Cliente;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class ClienteDaoImpl implements Dao<Cliente> {

    Session sf;
    Cliente cliente;
    List<Cliente> clientes;

    @Override
    public Cliente findById(int id) {
        sf = Dbcontext.IniciarSesion();
        cliente = (Cliente) sf.createCriteria(Cliente.class)
                .add(Restrictions.eq("idCliente", id))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN).uniqueResult();
        Dbcontext.CerrarSesion();
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        sf = Dbcontext.IniciarSesion();
//        clientes = (ArrayList<Cliente>) sf.createQuery("from Cliente where RegAnulado=0").list();
        clientes = sf.createCriteria(Cliente.class)
                .add(Restrictions.eq("regAnulado", false))
                .addOrder(Order.asc("razonSocial"))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return clientes;
    }

    public List<Cliente> findAll_WithAnualdos() {
        sf = Dbcontext.IniciarSesion();
        clientes = sf.createCriteria(Cliente.class)
                .addOrder(Order.asc("razonSocial"))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .list();
        Dbcontext.CerrarSesion();
        return clientes;
    }
}
