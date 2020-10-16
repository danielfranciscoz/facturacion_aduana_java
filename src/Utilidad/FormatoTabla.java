/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Daniel-Zamora
 */
public class FormatoTabla  implements TableCellRenderer {

    public static Font Negrilla = new Font("Lucida Grande", Font.BOLD, 12);
    
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        DefaultTableCellRenderer f = new DefaultTableCellRenderer();
        tabla.getTableHeader().setFont(Negrilla);
        JLabel editor = new JLabel();
        if (value != null) {
            editor.setText(value.toString());
        }
        if (column == 1) {
        editor.setFont(Negrilla);    
        }
        
        return editor;
    }

}
