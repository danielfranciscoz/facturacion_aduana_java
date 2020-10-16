package POJOs;
// Generated 06-08-2018 02:18:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private int cuentaRegistro;
     private Agencia agencia;
     private Cliente cliente;
     private Producto producto;
     private Usuario usuarioByUserImpresion;
     private Usuario usuarioByUserCreacion;
     private Usuario usuarioByUserModificacion;
     private String descripcion;
     private Boolean tipoTransaccion;
     private String numeroDeclaracion;
     private String tipoLlegada;
     private String remite;
     private String facturaExterna;
     private Double valorCif;
     private String estado;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private Date fechaImpresion;
     private String docsAdjuntos;
     private Set detallerecibos = new HashSet(0);
     private Set notadebitos = new HashSet(0);
     private Serviciosagencia serviciosagencia;

    public Factura() {
    }

	
    public Factura(int cuentaRegistro, Agencia agencia, Producto producto, Usuario usuarioByUserCreacion, String numeroDeclaracion, String tipoLlegada, String facturaExterna) {
        this.cuentaRegistro = cuentaRegistro;
        this.agencia = agencia;
        this.producto = producto;
        this.usuarioByUserCreacion = usuarioByUserCreacion;
        this.numeroDeclaracion = numeroDeclaracion;
        this.tipoLlegada = tipoLlegada;
        this.facturaExterna = facturaExterna;
    }
    public Factura(int cuentaRegistro, Agencia agencia, Cliente cliente, Producto producto, Usuario usuarioByUserImpresion, Usuario usuarioByUserCreacion, Usuario usuarioByUserModificacion, String descripcion, Boolean tipoTransaccion, String numeroDeclaracion, String tipoLlegada, String remite, String facturaExterna, Double valorCif, String estado, Date fechaCreacion, Date fechaModificacion, Date fechaImpresion, String docsAdjuntos, Set detallerecibos, Set notadebitos, Serviciosagencia serviciosagencia) {
       this.cuentaRegistro = cuentaRegistro;
       this.agencia = agencia;
       this.cliente = cliente;
       this.producto = producto;
       this.usuarioByUserImpresion = usuarioByUserImpresion;
       this.usuarioByUserCreacion = usuarioByUserCreacion;
       this.usuarioByUserModificacion = usuarioByUserModificacion;
       this.descripcion = descripcion;
       this.tipoTransaccion = tipoTransaccion;
       this.numeroDeclaracion = numeroDeclaracion;
       this.tipoLlegada = tipoLlegada;
       this.remite = remite;
       this.facturaExterna = facturaExterna;
       this.valorCif = valorCif;
       this.estado = estado;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.fechaImpresion = fechaImpresion;
       this.docsAdjuntos = docsAdjuntos;
       this.detallerecibos = detallerecibos;
       this.notadebitos = notadebitos;
       this.serviciosagencia = serviciosagencia;
    }
   
    public int getCuentaRegistro() {
        return this.cuentaRegistro;
    }
    
    public void setCuentaRegistro(int cuentaRegistro) {
        this.cuentaRegistro = cuentaRegistro;
    }
    public Agencia getAgencia() {
        return this.agencia;
    }
    
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Usuario getUsuarioByUserImpresion() {
        return this.usuarioByUserImpresion;
    }
    
    public void setUsuarioByUserImpresion(Usuario usuarioByUserImpresion) {
        this.usuarioByUserImpresion = usuarioByUserImpresion;
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
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getTipoTransaccion() {
        return this.tipoTransaccion;
    }
    
    public void setTipoTransaccion(Boolean tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    public String getNumeroDeclaracion() {
        return this.numeroDeclaracion;
    }
    
    public void setNumeroDeclaracion(String numeroDeclaracion) {
        this.numeroDeclaracion = numeroDeclaracion;
    }
    public String getTipoLlegada() {
        return this.tipoLlegada;
    }
    
    public void setTipoLlegada(String tipoLlegada) {
        this.tipoLlegada = tipoLlegada;
    }
    public String getRemite() {
        return this.remite;
    }
    
    public void setRemite(String remite) {
        this.remite = remite;
    }
    public String getFacturaExterna() {
        return this.facturaExterna;
    }
    
    public void setFacturaExterna(String facturaExterna) {
        this.facturaExterna = facturaExterna;
    }
    public Double getValorCif() {
        return this.valorCif;
    }
    
    public void setValorCif(Double valorCif) {
        this.valorCif = valorCif;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
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
    public Date getFechaImpresion() {
        return this.fechaImpresion;
    }
    
    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }
    public String getDocsAdjuntos() {
        return this.docsAdjuntos;
    }
    
    public void setDocsAdjuntos(String docsAdjuntos) {
        this.docsAdjuntos = docsAdjuntos;
    }
    public Set getDetallerecibos() {
        return this.detallerecibos;
    }
    
    public void setDetallerecibos(Set detallerecibos) {
        this.detallerecibos = detallerecibos;
    }
    public Set getNotadebitos() {
        return this.notadebitos;
    }
    
    public void setNotadebitos(Set notadebitos) {
        this.notadebitos = notadebitos;
    }
    public Serviciosagencia getServiciosagencia() {
        return this.serviciosagencia;
    }
    
    public void setServiciosagencia(Serviciosagencia serviciosagencia) {
        this.serviciosagencia = serviciosagencia;
    }




}

