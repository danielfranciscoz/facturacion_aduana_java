/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.FacturasDaoImpl;
import POJOs.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class FacturasBean {

    FacturasDaoImpl facturasDaoImpl;

    public FacturasBean() {
        facturasDaoImpl = new FacturasDaoImpl();
    }

    public Factura FindById(int id) {
        return facturasDaoImpl.findById(id);
    }

    public List<Factura> FindAll() {
        return facturasDaoImpl.findAll();
    }

    /**
     * Retorna las facturas ya sean anuales o por Mes y Año
     *
     * @param Mes int, cuando el Mes es -1 solo busca por año
     * @param Anio int
     * @return Lista de Facturas Mensuales o Anuales.
     */
    public List<Factura> FindAll(int Mes, int Anio) {
        if (Mes == -1) {
            return facturasDaoImpl.findAll(Anio);
        } else {
            return facturasDaoImpl.findAll(Mes, Anio);
        }
    }

    /**
     * Retorna las facturas por rando de fechas
     *
     * @param Inicio fecha Inicial del reporte
     * @param Fin fecha final del reporte
     * @return Lista de Facturas faltradas por fecha.
     */
    public List<Factura> FindByRandoFechas(Date Inicio, Date Fin) {
        return facturasDaoImpl.findRangoFechas(Inicio, Fin);
    }

    public int FacturaConsecutiva() {
        return facturasDaoImpl.findMayorID() + 1;
    }

    /**
     * Retorna los Meses o Años de las facturas creadas
     *
     * @param MesOAnio boolean, si es false busca Años, si es true busca Meses .
     * @return Lista de Meses o Años de las Facturas ya creadas.
     */
    public List<Integer> ObtenerMesesAnios(boolean MesOAnio) {
        List<Integer> Lista;
        if (MesOAnio) {
            Lista = facturasDaoImpl.findMeses();
        } else {
            Lista = facturasDaoImpl.findAnios();
        }
        return Lista;
    }

    /**
     * Retorna las facturas impresas y pagadas Asociadas a un cliente
     *
     * @param IdCliente int, El Id del Cliente .
     * @return Lista de facturas asociadas a un cliente.
     */
    public List<Factura> ObtenerFacturasClientes(int IdCliente) {
        return facturasDaoImpl.findClientesFacturas(IdCliente);
    }
}
