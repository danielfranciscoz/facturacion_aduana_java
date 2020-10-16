package POJOs;
// Generated 06-08-2018 02:18:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Agencia generated by hbm2java
 */
public class Agencia  implements java.io.Serializable {


     private Integer idAgencia;
     private Usuario usuarioByUserModificacion;
     private Usuario usuarioByUserCreacion;
     private String nombre;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private Boolean regAnulado;
     private Set facturas = new HashSet(0);

    public Agencia() {
    }

	
    public Agencia(Usuario usuarioByUserCreacion, String nombre) {
        this.usuarioByUserCreacion = usuarioByUserCreacion;
        this.nombre = nombre;
    }
    public Agencia(Usuario usuarioByUserModificacion, Usuario usuarioByUserCreacion, String nombre, Date fechaCreacion, Date fechaModificacion, Boolean regAnulado, Set facturas) {
       this.usuarioByUserModificacion = usuarioByUserModificacion;
       this.usuarioByUserCreacion = usuarioByUserCreacion;
       this.nombre = nombre;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.regAnulado = regAnulado;
       this.facturas = facturas;
    }
   
    public Integer getIdAgencia() {
        return this.idAgencia;
    }
    
    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }
    public Usuario getUsuarioByUserModificacion() {
        return this.usuarioByUserModificacion;
    }
    
    public void setUsuarioByUserModificacion(Usuario usuarioByUserModificacion) {
        this.usuarioByUserModificacion = usuarioByUserModificacion;
    }
    public Usuario getUsuarioByUserCreacion() {
        return this.usuarioByUserCreacion;
    }
    
    public void setUsuarioByUserCreacion(Usuario usuarioByUserCreacion) {
        this.usuarioByUserCreacion = usuarioByUserCreacion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Boolean getRegAnulado() {
        return this.regAnulado;
    }
    
    public void setRegAnulado(Boolean regAnulado) {
        this.regAnulado = regAnulado;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }




}


