/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplementation;

import Conexion.Dbcontext;
import DaoInterface.Dao;
import POJOs.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel-Zamora
 */
public class ProductoDaoImpl implements Dao<Producto> {

    Session sf;
    Producto producto;
    List<Producto> productos;

    @Override
    public Producto findById(int id) {
        sf = Dbcontext.IniciarSesion();
        producto = (Producto) sf.createCriteria(Producto.class)
                .add(Restrictions.eq("idProducto", id))
                .setFetchMode("usuarioByUserModificacion", FetchMode.JOIN)
                .setFetchMode("usuarioByUserCreacion", FetchMode.JOIN)
                .uniqueResult();
        Dbcontext.CerrarSesion();
        return producto;
    }

    @Override
    public List<Producto> findAll() {
        sf = Dbcontext.IniciarSesion();
        productos = (ArrayList<Producto>) sf.createQuery("from Producto p JOIN FETCH p.usuarioByUserCreacion uuc JOIN FETCH p.usuarioByUserModificacion uum where p.regAnulado=0 order by p.nombre asc").list();
        Dbcontext.CerrarSesion();
        return productos;
    }

    public List<Producto> findAll_WithAnulados() {
        sf = Dbcontext.IniciarSesion();
        productos = (ArrayList<Producto>) sf.createQuery("from Producto p JOIN FETCH p.usuarioByUserCreacion uuc JOIN FETCH p.usuarioByUserModificacion uum order by p.nombre asc").list();
        Dbcontext.CerrarSesion();
        return productos;
    }
}
