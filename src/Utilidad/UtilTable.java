package Utilidad;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Daniel-Zamora
 */
public class UtilTable {

    /*Metodo que limpia las filas del modelo de la tabla*/
    public static void LimpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static void LimpiarTabla(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static Boolean isAnyoneSelected(JTable tabla) {
        return tabla.getSelectedRow() > -1;
    }

    public static int getSelectedOnColumn(JTable tabla, int column) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int index = tabla.getSelectedRow();
        int value = Integer.parseInt(modelo.getValueAt(index, column).toString());
        return value;
    }

    public static Object getSelectedValue(JTable tabla, int column) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int index = tabla.getSelectedRow();
        return modelo.getValueAt(index, column);
    }

    public static void RemoveRow(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int index[] = tabla.getSelectedRows();
        for (int i = index.length - 1; i >= 0; i--) {
            modelo.removeRow(index[i]);
        }
    }

    public static void ExportarExcel(JTable tabla, String fileName) throws IOException, WriteException {
        TableModel modelo = tabla.getModel();
        int ultima_fila = 0;

        String path = System.getProperties().getProperty("user.home") + "\\Desktop\\" + fileName + ".xls";
        File archivo = new File(path);
        WritableWorkbook libro = Workbook.createWorkbook(archivo);
        WritableSheet hoja = libro.createSheet("Agencia Hoja 1", 0);

        WritableCellFormat titulo = new WritableCellFormat();
        titulo.setAlignment(Alignment.CENTRE);
        titulo.setFont(new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD));

        WritableCellFormat dataCellFormat = new WritableCellFormat();
        dataCellFormat.setAlignment(Alignment.CENTRE);

        // CARGANDO TITULOS DE LA TABLA
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            hoja.addCell(new jxl.write.Label(i, ultima_fila, modelo.getColumnName(i), titulo));
            hoja.setColumnView(i, 20);
        }
        ultima_fila++;

        // CARGANDO DATOS DE LA TABLA
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                Object value = modelo.getValueAt(i, j);
                if (value != null) {
                    try {
                        double numero = Double.valueOf(String.valueOf(value).replace(",", ""));
                        hoja.addCell(new jxl.write.Number(j, ultima_fila, numero, dataCellFormat));
                    } catch (NumberFormatException ex) {
                        hoja.addCell(new jxl.write.Label(j, ultima_fila, value.toString(), dataCellFormat));
                    }
                }
            }
            ultima_fila++;
        }

        ultima_fila += 2;

        // ESCRIBIMOS EL ARCHIVO
        libro.write();

        // CERRAMOS EL ARCHIVO
        libro.close();
    }

    public static void ExportarExcel_WithFileDIR(JTable tabla, String Direccion) throws IOException, WriteException {
        TableModel modelo = tabla.getModel();
        int ultima_fila = 0;
        if (Direccion.contains(".xls")) {
            Direccion = Direccion.replaceFirst(".xls", "");
        }
        File archivo = new File(Direccion + ".xls");
        WritableWorkbook libro = Workbook.createWorkbook(archivo);
        WritableSheet hoja = libro.createSheet("Agencia Hoja 1", 0);

        WritableCellFormat titulo = new WritableCellFormat();
        titulo.setAlignment(Alignment.CENTRE);
        titulo.setFont(new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD));

        WritableCellFormat dataCellFormat = new WritableCellFormat();
        dataCellFormat.setAlignment(Alignment.CENTRE);

        // CARGANDO TITULOS DE LA TABLA
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            hoja.addCell(new jxl.write.Label(i, ultima_fila, modelo.getColumnName(i), titulo));
            hoja.setColumnView(i, 20);
        }
        ultima_fila++;

        // CARGANDO DATOS DE LA TABLA
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                Object value = modelo.getValueAt(i, j);
                if (value != null) {
                    try {
                        double numero = Double.valueOf(String.valueOf(value).replace(",", ""));
                        hoja.addCell(new jxl.write.Number(j, ultima_fila, numero, dataCellFormat));
                    } catch (NumberFormatException ex) {
                        hoja.addCell(new jxl.write.Label(j, ultima_fila, value.toString(), dataCellFormat));
                    }
                }
            }
            ultima_fila++;
        }

        ultima_fila += 2;

        // ESCRIBIMOS EL ARCHIVO
        libro.write();

        // CERRAMOS EL ARCHIVO
        libro.close();
    }

    public static void Exportar(Component componente,JTable jTable1) {
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.lxs", "xls");
        file.setFileFilter(filtro);
        int seleccion = file.showSaveDialog(componente);
        File guarda = file.getSelectedFile();
        if (guarda != null && seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                UtilTable.ExportarExcel_WithFileDIR(jTable1, guarda.getAbsolutePath());
                Mensajes.OperacionExitosa(componente);
                // TODO add your handling code here:
            } catch (IOException | WriteException ex) {
               Mensajes.ErrorMessage(componente, "Error al exportar", ex.getMessage());
            }

        }
    }
}
