package pruebaReporte;

import Reportes.Reporte;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author W4LT3R
 */
public class reporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"detalle", "parcial", "monto"});
        modelo.addRow(new Object[]{
            "Viatico de alimentacion y transporte en atencion a declaracion de importacion #C-12069/0, CONT. 892 BTS CIPERMETRINA, EN ADUANA PUERTO CORINTO",
            "", new Double(500)});
        modelo.addRow(new Object[]{Reporte.boldLetter("mesa"), "", new Double(2300) });
        modelo.addRow(new Object[]{"sillas", "", new Double(5120) });
        modelo.addRow(new Object[]{"estuche", "", new Double(1232) });
        modelo.addRow(new Object[]{"frijoles", "", new Double(403)});
        modelo.addRow(new Object[]{"arroz", "", new Double(123)});


        System.out.println("Cargando Reporte...");

        Reporte reporte = new Reporte("RptNotaDebito.jasper");
        reporte.AddParameter("cliente", "Walter Ramon Corrales Diaz");
        reporte.AddParameter("direccion", "en managua del palo de mango una al guindo");
        reporte.AddParameter("ruc", "J0310000032777");
        reporte.AddParameter("fecha", new Date());
        reporte.AddParameter("cuentaRegistro", 16170);
        reporte.AddParameter("tipo", "EXPORTACION");
        reporte.AddParameter("declaracion", "#C-12800/0");
        reporte.AddParameter("aduana", "PUERTO CORINTO");
        reporte.AddDataSource(modelo);
        reporte.setZoom(1f);
        reporte.Show();

        System.out.println("Reporte Cargado...");
    }
}