package Reportes;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author W4LT3R
 */
public class Reporte {

    JasperReport reporte;
    JasperPrint imprime;
    JasperViewer vista;

    Map parametros = new HashMap<>();
    JRTableModelDataSource datasource;
    String fileReport;

    private float zoom = 0.75f;

    public static String boldLetter(String texto) {
        return "<b>" + texto + "</b>";
    }

    public void LoadJasperReport() throws JRException {
        reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/" + this.fileReport));
        LoadJasperPrint();
    }

    public Reporte(String fileReport) {
        try {
            this.fileReport = fileReport;
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/" + fileReport));
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("Error Cargando el reporte:\n" + fileReport);
        }
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    private void LoadJasperPrint() {
        try {
            if (datasource != null) {
                imprime = JasperFillManager.fillReport(reporte, parametros, datasource);
            } else {
                imprime = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
            }
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("Error Cargando el JasperPrint:\n" + fileReport);
        }
    }

    public void AddParameter(String key, Object value) {
        parametros.put(key, value);
    }

    public void AddDataSource(JTable tabla) {
        datasource = new JRTableModelDataSource((DefaultTableModel) tabla.getModel());
    }

    public void AddDataSource(DefaultTableModel modelo) {
        datasource = new JRTableModelDataSource(modelo);
    }

    public JPanel getVisor() {
        LoadJasperPrint();
        JPanel panel = new JPanel(new BorderLayout());
        JRViewer visor = new JRViewer(imprime);
        visor.setZoomRatio(zoom);
        panel.add(visor, BorderLayout.CENTER);
        return panel;
    }

    public void Show() {
        LoadJasperPrint();
        vista = new JasperViewer(imprime, false);
        vista.setZoomRatio(zoom);
        vista.setTitle(imprime.getName());
        vista.setExtendedState(6);
        vista.setAutoRequestFocus(true);
        vista.setMaximizedBounds(new Rectangle(0, 0, 1366, 728));
        vista.setVisible(true);
    }

}
