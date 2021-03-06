package POJOs;
// Generated 06-08-2018 02:18:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String idUsuario;
     private Empleado empleado;
     private Rol rol;
     private Usuario usuarioByUserCreacion;
     private Usuario usuarioByUserModificacion;
     private String password;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private Boolean regAnulado;
     private Set notadebitosForUserImpresion = new HashSet(0);
     private Set productosForUserModificacion = new HashSet(0);
     private Set rolsForUserModificacion = new HashSet(0);
     private Set clientesForUserCreacion = new HashSet(0);
     private Set recibosForUserModificacion = new HashSet(0);
     private Set facturasForUserImpresion = new HashSet(0);
     private Set agenciasForUserModificacion = new HashSet(0);
     private Set facturasForUserCreacion = new HashSet(0);
     private Set recibosForUserCreacion = new HashSet(0);
     private Set registrosanuladoses = new HashSet(0);
     private Set detallenotadebitosForUserCreacion = new HashSet(0);
     private Set detallenotadebitosForUserModificacion = new HashSet(0);
     private Set empleadosForUserModificacion = new HashSet(0);
     private Set clientesForUserModificacion = new HashSet(0);
     private Set permisosForUserCreacion = new HashSet(0);
     private Set facturasForUserModificacion = new HashSet(0);
     private Set pantallasForUserModificacion = new HashSet(0);
     private Set empleadosForUserCreacion = new HashSet(0);
     private Set notadebitosForUserCreacion = new HashSet(0);
     private Set notadebitosForUserModificacion = new HashSet(0);
     private Set usuariosForUserCreacion = new HashSet(0);
     private Set permisosForUserModificacion = new HashSet(0);
     private Set pantallasForUserCreacion = new HashSet(0);
     private Set usuariosForUserModificacion = new HashSet(0);
     private Set productosForUserCreacion = new HashSet(0);
     private Set agenciasForUserCreacion = new HashSet(0);
     private Set rolsForUserCreacion = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String idUsuario, Empleado empleado, Rol rol, String password) {
        this.idUsuario = idUsuario;
        this.empleado = empleado;
        this.rol = rol;
        this.password = password;
    }
    public Usuario(String idUsuario, Empleado empleado, Rol rol, Usuario usuarioByUserCreacion, Usuario usuarioByUserModificacion, String password, Date fechaCreacion, Date fechaModificacion, Boolean regAnulado, Set notadebitosForUserImpresion, Set productosForUserModificacion, Set rolsForUserModificacion, Set clientesForUserCreacion, Set recibosForUserModificacion, Set facturasForUserImpresion, Set agenciasForUserModificacion, Set facturasForUserCreacion, Set recibosForUserCreacion, Set registrosanuladoses, Set detallenotadebitosForUserCreacion, Set detallenotadebitosForUserModificacion, Set empleadosForUserModificacion, Set clientesForUserModificacion, Set permisosForUserCreacion, Set facturasForUserModificacion, Set pantallasForUserModificacion, Set empleadosForUserCreacion, Set notadebitosForUserCreacion, Set notadebitosForUserModificacion, Set usuariosForUserCreacion, Set permisosForUserModificacion, Set pantallasForUserCreacion, Set usuariosForUserModificacion, Set productosForUserCreacion, Set agenciasForUserCreacion, Set rolsForUserCreacion) {
       this.idUsuario = idUsuario;
       this.empleado = empleado;
       this.rol = rol;
       this.usuarioByUserCreacion = usuarioByUserCreacion;
       this.usuarioByUserModificacion = usuarioByUserModificacion;
       this.password = password;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.regAnulado = regAnulado;
       this.notadebitosForUserImpresion = notadebitosForUserImpresion;
       this.productosForUserModificacion = productosForUserModificacion;
       this.rolsForUserModificacion = rolsForUserModificacion;
       this.clientesForUserCreacion = clientesForUserCreacion;
       this.recibosForUserModificacion = recibosForUserModificacion;
       this.facturasForUserImpresion = facturasForUserImpresion;
       this.agenciasForUserModificacion = agenciasForUserModificacion;
       this.facturasForUserCreacion = facturasForUserCreacion;
       this.recibosForUserCreacion = recibosForUserCreacion;
       this.registrosanuladoses = registrosanuladoses;
       this.detallenotadebitosForUserCreacion = detallenotadebitosForUserCreacion;
       this.detallenotadebitosForUserModificacion = detallenotadebitosForUserModificacion;
       this.empleadosForUserModificacion = empleadosForUserModificacion;
       this.clientesForUserModificacion = clientesForUserModificacion;
       this.permisosForUserCreacion = permisosForUserCreacion;
       this.facturasForUserModificacion = facturasForUserModificacion;
       this.pantallasForUserModificacion = pantallasForUserModificacion;
       this.empleadosForUserCreacion = empleadosForUserCreacion;
       this.notadebitosForUserCreacion = notadebitosForUserCreacion;
       this.notadebitosForUserModificacion = notadebitosForUserModificacion;
       this.usuariosForUserCreacion = usuariosForUserCreacion;
       this.permisosForUserModificacion = permisosForUserModificacion;
       this.pantallasForUserCreacion = pantallasForUserCreacion;
       this.usuariosForUserModificacion = usuariosForUserModificacion;
       this.productosForUserCreacion = productosForUserCreacion;
       this.agenciasForUserCreacion = agenciasForUserCreacion;
       this.rolsForUserCreacion = rolsForUserCreacion;
    }
   
    public String getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    public Set getNotadebitosForUserImpresion() {
        return this.notadebitosForUserImpresion;
    }
    
    public void setNotadebitosForUserImpresion(Set notadebitosForUserImpresion) {
        this.notadebitosForUserImpresion = notadebitosForUserImpresion;
    }
    public Set getProductosForUserModificacion() {
        return this.productosForUserModificacion;
    }
    
    public void setProductosForUserModificacion(Set productosForUserModificacion) {
        this.productosForUserModificacion = productosForUserModificacion;
    }
    public Set getRolsForUserModificacion() {
        return this.rolsForUserModificacion;
    }
    
    public void setRolsForUserModificacion(Set rolsForUserModificacion) {
        this.rolsForUserModificacion = rolsForUserModificacion;
    }
    public Set getClientesForUserCreacion() {
        return this.clientesForUserCreacion;
    }
    
    public void setClientesForUserCreacion(Set clientesForUserCreacion) {
        this.clientesForUserCreacion = clientesForUserCreacion;
    }
    public Set getRecibosForUserModificacion() {
        return this.recibosForUserModificacion;
    }
    
    public void setRecibosForUserModificacion(Set recibosForUserModificacion) {
        this.recibosForUserModificacion = recibosForUserModificacion;
    }
    public Set getFacturasForUserImpresion() {
        return this.facturasForUserImpresion;
    }
    
    public void setFacturasForUserImpresion(Set facturasForUserImpresion) {
        this.facturasForUserImpresion = facturasForUserImpresion;
    }
    public Set getAgenciasForUserModificacion() {
        return this.agenciasForUserModificacion;
    }
    
    public void setAgenciasForUserModificacion(Set agenciasForUserModificacion) {
        this.agenciasForUserModificacion = agenciasForUserModificacion;
    }
    public Set getFacturasForUserCreacion() {
        return this.facturasForUserCreacion;
    }
    
    public void setFacturasForUserCreacion(Set facturasForUserCreacion) {
        this.facturasForUserCreacion = facturasForUserCreacion;
    }
    public Set getRecibosForUserCreacion() {
        return this.recibosForUserCreacion;
    }
    
    public void setRecibosForUserCreacion(Set recibosForUserCreacion) {
        this.recibosForUserCreacion = recibosForUserCreacion;
    }
    public Set getRegistrosanuladoses() {
        return this.registrosanuladoses;
    }
    
    public void setRegistrosanuladoses(Set registrosanuladoses) {
        this.registrosanuladoses = registrosanuladoses;
    }
    public Set getDetallenotadebitosForUserCreacion() {
        return this.detallenotadebitosForUserCreacion;
    }
    
    public void setDetallenotadebitosForUserCreacion(Set detallenotadebitosForUserCreacion) {
        this.detallenotadebitosForUserCreacion = detallenotadebitosForUserCreacion;
    }
    public Set getDetallenotadebitosForUserModificacion() {
        return this.detallenotadebitosForUserModificacion;
    }
    
    public void setDetallenotadebitosForUserModificacion(Set detallenotadebitosForUserModificacion) {
        this.detallenotadebitosForUserModificacion = detallenotadebitosForUserModificacion;
    }
    public Set getEmpleadosForUserModificacion() {
        return this.empleadosForUserModificacion;
    }
    
    public void setEmpleadosForUserModificacion(Set empleadosForUserModificacion) {
        this.empleadosForUserModificacion = empleadosForUserModificacion;
    }
    public Set getClientesForUserModificacion() {
        return this.clientesForUserModificacion;
    }
    
    public void setClientesForUserModificacion(Set clientesForUserModificacion) {
        this.clientesForUserModificacion = clientesForUserModificacion;
    }
    public Set getPermisosForUserCreacion() {
        return this.permisosForUserCreacion;
    }
    
    public void setPermisosForUserCreacion(Set permisosForUserCreacion) {
        this.permisosForUserCreacion = permisosForUserCreacion;
    }
    public Set getFacturasForUserModificacion() {
        return this.facturasForUserModificacion;
    }
    
    public void setFacturasForUserModificacion(Set facturasForUserModificacion) {
        this.facturasForUserModificacion = facturasForUserModificacion;
    }
    public Set getPantallasForUserModificacion() {
        return this.pantallasForUserModificacion;
    }
    
    public void setPantallasForUserModificacion(Set pantallasForUserModificacion) {
        this.pantallasForUserModificacion = pantallasForUserModificacion;
    }
    public Set getEmpleadosForUserCreacion() {
        return this.empleadosForUserCreacion;
    }
    
    public void setEmpleadosForUserCreacion(Set empleadosForUserCreacion) {
        this.empleadosForUserCreacion = empleadosForUserCreacion;
    }
    public Set getNotadebitosForUserCreacion() {
        return this.notadebitosForUserCreacion;
    }
    
    public void setNotadebitosForUserCreacion(Set notadebitosForUserCreacion) {
        this.notadebitosForUserCreacion = notadebitosForUserCreacion;
    }
    public Set getNotadebitosForUserModificacion() {
        return this.notadebitosForUserModificacion;
    }
    
    public void setNotadebitosForUserModificacion(Set notadebitosForUserModificacion) {
        this.notadebitosForUserModificacion = notadebitosForUserModificacion;
    }
    public Set getUsuariosForUserCreacion() {
        return this.usuariosForUserCreacion;
    }
    
    public void setUsuariosForUserCreacion(Set usuariosForUserCreacion) {
        this.usuariosForUserCreacion = usuariosForUserCreacion;
    }
    public Set getPermisosForUserModificacion() {
        return this.permisosForUserModificacion;
    }
    
    public void setPermisosForUserModificacion(Set permisosForUserModificacion) {
        this.permisosForUserModificacion = permisosForUserModificacion;
    }
    public Set getPantallasForUserCreacion() {
        return this.pantallasForUserCreacion;
    }
    
    public void setPantallasForUserCreacion(Set pantallasForUserCreacion) {
        this.pantallasForUserCreacion = pantallasForUserCreacion;
    }
    public Set getUsuariosForUserModificacion() {
        return this.usuariosForUserModificacion;
    }
    
    public void setUsuariosForUserModificacion(Set usuariosForUserModificacion) {
        this.usuariosForUserModificacion = usuariosForUserModificacion;
    }
    public Set getProductosForUserCreacion() {
        return this.productosForUserCreacion;
    }
    
    public void setProductosForUserCreacion(Set productosForUserCreacion) {
        this.productosForUserCreacion = productosForUserCreacion;
    }
    public Set getAgenciasForUserCreacion() {
        return this.agenciasForUserCreacion;
    }
    
    public void setAgenciasForUserCreacion(Set agenciasForUserCreacion) {
        this.agenciasForUserCreacion = agenciasForUserCreacion;
    }
    public Set getRolsForUserCreacion() {
        return this.rolsForUserCreacion;
    }
    
    public void setRolsForUserCreacion(Set rolsForUserCreacion) {
        this.rolsForUserCreacion = rolsForUserCreacion;
    }




}


