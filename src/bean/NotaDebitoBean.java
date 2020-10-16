/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import DaoImplementation.NotaDebitoDaoImpl;
import POJOs.Notadebito;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel-Zamora
 */
public class NotaDebitoBean {

    NotaDebitoDaoImpl notaDebitoDaoImpl;

    public NotaDebitoBean() {
        notaDebitoDaoImpl = new NotaDebitoDaoImpl();
    }

    public List<Notadebito> FindAll(int CuentaRegistro) {
        return notaDebitoDaoImpl.findAll(CuentaRegistro);
    }

    public List<Notadebito> FindAllCliente(int IdCliente) {
        return notaDebitoDaoImpl.findAllCiente(IdCliente);
    }

    public List<Notadebito> FindAllCliente() {
        return notaDebitoDaoImpl.findAllCiente();
    }
    
    public List<Notadebito> FindAllClienteTime(int Mes, int Anio) {
        if (Mes == -1) {
            return notaDebitoDaoImpl.findAllCiente(""+Anio);
        } else {
            return notaDebitoDaoImpl.findAllCiente(Mes, Anio);
        }
    }

    public List<Notadebito> FindAllClienteRango(Date inicio, Date Fin) {
        return notaDebitoDaoImpl.findAllCienteByRangoFecha(inicio, Fin);
    }

    public Notadebito findById(int id) {
        return notaDebitoDaoImpl.findById(id);
    }

    public int NotaDebitoConsecutiva() {
        return notaDebitoDaoImpl.findMayorID() + 1;
    }

    /**
     * Retorna los Meses o Años de las notas de debito creadas
     *
     * @param MesOAnio boolean, si es false busca Años, si es true busca Meses .
     * @return Lista de Meses o Años de las notas de debito ya creadas.
     */
    public List<Integer> ObtenerMesesAnios(boolean MesOAnio) {
        List<Integer> Lista;
        if (MesOAnio) {
            Lista = notaDebitoDaoImpl.findMeses();
        } else {
            Lista = notaDebitoDaoImpl.findAnios();
        }
        return Lista;
    }

    public List<Notadebito> FindByTipo(int Opcion, int Mes, int Anio, Date Inicial, Date Final) {
        List<Notadebito> notas = new ArrayList<>();
        System.out.println("La opcion de exportacion es " + Opcion);
        switch (Opcion) {
            case 0: // Quiere los registros por mes
                notas = notaDebitoDaoImpl.findAll(Mes, "" + Anio);
                break;
            case 1: // Quiere los registros por Rango de Fechas
                notas = notaDebitoDaoImpl.findRangoFechas(Inicial, Final);
                break;
            case 2: // Quiere los registros por Año
                notas = notaDebitoDaoImpl.findAll("" + Anio);
                break;
            case 3: // Quiere todos los registros
                notas = notaDebitoDaoImpl.findAll();
                break;

        }
        return notas;
    }

}
