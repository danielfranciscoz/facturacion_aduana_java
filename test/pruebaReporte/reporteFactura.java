package pruebaReporte;

import Reportes.Reporte;
import java.util.Date;

/**
 *
 * @author W4LT3R
 */
public class reporteFactura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reporte reporte = new Reporte("RptFactura.jasper");
        reporte.AddParameter("docAdjunto", "R#139102445117A \nDGA R#19480 \nMAERSK R#11.0826");

        reporte.AddParameter("empresa", "Walter Ramon Corrales Diaz");
        reporte.AddParameter("ruc", "J0310000032777");
        reporte.AddParameter("lugar", "managua");
        reporte.AddParameter("transporte", "TERRESTRE");
        reporte.AddParameter("remisor", "Agrosciences Co. Ltd.");
        reporte.AddParameter("factura", "16CAGTSC005");
        reporte.AddParameter("cif", 251123.6456);
        reporte.AddParameter("descripcion", "892 bultos conteniendo cipermetrina 25 EC insectisidas, Aduana Puerto Corinto, Declaración de importación C-12069/0");

        reporte.AddParameter("notaDebito", new Double(0));
        reporte.AddParameter("total", new Double(12310));

        reporte.AddParameter("srvHonorarios", 1432.43);
        reporte.AddParameter("srvManejo", 1432.43);
        reporte.AddParameter("srvValorizacion", 1432.43);
        reporte.AddParameter("srvPartidas", 1432.43);

        boolean isApplyToIVA = true;
        if (isApplyToIVA) {
            reporte.AddParameter("iva", (1432 * 4) * 0.15);
        } else {
            reporte.AddParameter("iva", 0);
        }

        reporte.AddParameter("fecha", new Date());
        reporte.setZoom(1f);

        reporte.Show();
    }

}
