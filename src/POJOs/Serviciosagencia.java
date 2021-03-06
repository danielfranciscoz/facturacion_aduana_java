package POJOs;
// Generated 06-08-2018 02:18:23 PM by Hibernate Tools 4.3.1



/**
 * Serviciosagencia generated by hbm2java
 */
public class Serviciosagencia  implements java.io.Serializable {


     private int cuentaRegistro;
     private Factura factura;
     private Double honorario;
     private Double manejo;
     private Double valorizacion;
     private Double partidasAdicionales;
     private Boolean aplicaIva;

    public Serviciosagencia() {
    }

	
    public Serviciosagencia(Factura factura) {
        this.factura = factura;
    }
    public Serviciosagencia(Factura factura, Double honorario, Double manejo, Double valorizacion, Double partidasAdicionales, Boolean aplicaIva) {
       this.factura = factura;
       this.honorario = honorario;
       this.manejo = manejo;
       this.valorizacion = valorizacion;
       this.partidasAdicionales = partidasAdicionales;
       this.aplicaIva = aplicaIva;
    }
   
    public int getCuentaRegistro() {
        return this.cuentaRegistro;
    }
    
    public void setCuentaRegistro(int cuentaRegistro) {
        this.cuentaRegistro = cuentaRegistro;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Double getHonorario() {
        return this.honorario;
    }
    
    public void setHonorario(Double honorario) {
        this.honorario = honorario;
    }
    public Double getManejo() {
        return this.manejo;
    }
    
    public void setManejo(Double manejo) {
        this.manejo = manejo;
    }
    public Double getValorizacion() {
        return this.valorizacion;
    }
    
    public void setValorizacion(Double valorizacion) {
        this.valorizacion = valorizacion;
    }
    public Double getPartidasAdicionales() {
        return this.partidasAdicionales;
    }
    
    public void setPartidasAdicionales(Double partidasAdicionales) {
        this.partidasAdicionales = partidasAdicionales;
    }
    public Boolean getAplicaIva() {
        return this.aplicaIva;
    }
    
    public void setAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }




}


