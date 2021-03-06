package POJOs;
// Generated 06-08-2018 02:18:23 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Permiso generated by hbm2java
 */
public class Permiso  implements java.io.Serializable {


     private PermisoId id;
     private Pantalla pantalla;
     private Rol rol;
     private Usuario usuarioByUserCreacion;
     private Usuario usuarioByUserModificacion;
     private Boolean insertar;
     private Boolean modificar;
     private Boolean eliminar;
     private Boolean autorizar;
     private Boolean denegar;
     private Boolean buscar;
     private Boolean exportar;
     private Boolean imprimir;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private Boolean regAnulado;

    public Permiso() {
    }

	
    public Permiso(PermisoId id, Pantalla pantalla, Rol rol, Usuario usuarioByUserCreacion) {
        this.id = id;
        this.pantalla = pantalla;
        this.rol = rol;
        this.usuarioByUserCreacion = usuarioByUserCreacion;
    }
    public Permiso(PermisoId id, Pantalla pantalla, Rol rol, Usuario usuarioByUserCreacion, Usuario usuarioByUserModificacion, Boolean insertar, Boolean modificar, Boolean eliminar, Boolean autorizar, Boolean denegar, Boolean buscar, Boolean exportar, Boolean imprimir, Date fechaCreacion, Date fechaModificacion, Boolean regAnulado) {
       this.id = id;
       this.pantalla = pantalla;
       this.rol = rol;
       this.usuarioByUserCreacion = usuarioByUserCreacion;
       this.usuarioByUserModificacion = usuarioByUserModificacion;
       this.insertar = insertar;
       this.modificar = modificar;
       this.eliminar = eliminar;
       this.autorizar = autorizar;
       this.denegar = denegar;
       this.buscar = buscar;
       this.exportar = exportar;
       this.imprimir = imprimir;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.regAnulado = regAnulado;
    }
   
    public PermisoId getId() {
        return this.id;
    }
    
    public void setId(PermisoId id) {
        this.id = id;
    }
    public Pantalla getPantalla() {
        return this.pantalla;
    }
    
    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Usuario getUsuarioByUserCreacion() {
        return this.usuarioByUserCreacion;
    }
    
    public void setUsuarioByUserCreacion(Usuario usuarioByUserCreacion) {
        this.usuarioByUserCreacion = usuarioByUserCreacion;
    }
    public Usuario getUsuarioByUserModificacion() {
        return this.usuarioByUserModificacion;
    }
    
    public void setUsuarioByUserModificacion(Usuario usuarioByUserModificacion) {
        this.usuarioByUserModificacion = usuarioByUserModificacion;
    }
    public Boolean getInsertar() {
        return this.insertar;
    }
    
    public void setInsertar(Boolean insertar) {
        this.insertar = insertar;
    }
    public Boolean getModificar() {
        return this.modificar;
    }
    
    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }
    public Boolean getEliminar() {
        return this.eliminar;
    }
    
    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }
    public Boolean getAutorizar() {
        return this.autorizar;
    }
    
    public void setAutorizar(Boolean autorizar) {
        this.autorizar = autorizar;
    }
    public Boolean getDenegar() {
        return this.denegar;
    }
    
    public void setDenegar(Boolean denegar) {
        this.denegar = denegar;
    }
    public Boolean getBuscar() {
        return this.buscar;
    }
    
    public void setBuscar(Boolean buscar) {
        this.buscar = buscar;
    }
    public Boolean getExportar() {
        return this.exportar;
    }
    
    public void setExportar(Boolean exportar) {
        this.exportar = exportar;
    }
    public Boolean getImprimir() {
        return this.imprimir;
    }
    
    public void setImprimir(Boolean imprimir) {
        this.imprimir = imprimir;
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




}


