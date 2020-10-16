/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.DetalleReciboDaoImpl;
import DaoImplementation.ReciboDaoImpl;
import POJOs.Recibo;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class ReciboBean {

    ReciboDaoImpl reciboDaoImpl;
    DetalleReciboDaoImpl detalleReciboDaoImpl;

    public ReciboBean() {
        reciboDaoImpl = new ReciboDaoImpl();
        detalleReciboDaoImpl = new DetalleReciboDaoImpl();
    }

    /**
     * Retorna los pagos realizados por determinado cliente
     *
     * @param IdCliente cuando el cliente es -1, busca todos los registros del
     * mes y año
     * @param Mes cuando el Mes es -1 busca solo por cliente
     * @param Anio
     * @return Lista de pagos realizados por un cliente.
     */
    public List<Recibo> FindAll(int IdCliente, int Mes, int Anio) {
        if (Mes == -1) {
            return reciboDaoImpl.findAll(IdCliente);
        } else {
            return reciboDaoImpl.findAll(IdCliente, Mes, Anio);
        }
    }

    public double MontoRecibo(int IdRecibo) {
        return detalleReciboDaoImpl.MontoRecibo(IdRecibo);
    }

    /**
     * Retorna los Meses o Años de los Recibos creados
     *
     * @param MesOAnio boolean, si es false busca Años, si es true busca Meses .
     * @return Lista de Meses o Años de los Recibos ya creados.
     */
    public List<Integer> ObtenerMesesAnios(boolean MesOAnio) {
        List<Integer> Lista;
        if (MesOAnio) {
            Lista = reciboDaoImpl.findMeses();
        } else {
            Lista = reciboDaoImpl.findAnios();
        }
        return Lista;
    }

    public int NoReciboConsecutivo() {
        return reciboDaoImpl.findMayorID() + 1;
    }
}
