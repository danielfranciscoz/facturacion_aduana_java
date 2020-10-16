/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.DetalleReciboDaoImpl;
import POJOs.Detallerecibo;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class DetalleReciboBean {

    DetalleReciboDaoImpl detalleReciboDaoImpl;

    public DetalleReciboBean() {
        detalleReciboDaoImpl = new DetalleReciboDaoImpl();
    }

    public List<Detallerecibo> FindAll(int NoRecibo) {
        return detalleReciboDaoImpl.findAll(NoRecibo);
    }

    /**
     * Retorna Monto pagado por el cliente
     *
     * @param Tipo boolean, si es True busca Monto Pagado de Factura, en caso
     * contrario busca el monto pagado de las notas de débito
     * @param IdRegistro int
     * @return Monto pagado ya sea por factura o por Nota de Débito.
     */
    public double MontoPagado(boolean Tipo, int IdRegistro) {
        double Monto;
        if (Tipo) {
            Monto = detalleReciboDaoImpl.MontoPagadoFactura(IdRegistro);
        } else {
            Monto = detalleReciboDaoImpl.MontoPagadoNotaDebito(IdRegistro);
        }
        return Monto;
    }

    public int ObtenerCantidadFacturasAbonadas(int CuentaRegistro) {
        return detalleReciboDaoImpl.findByCuentaRegistro(CuentaRegistro);
    }

    public int ObtenerCantidadNotasDebitoAbonadas(int NotaDebito) {
        return detalleReciboDaoImpl.findByNotaDebito(NotaDebito);
    }
}
