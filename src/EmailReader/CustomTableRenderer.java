/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author r.ilyenko
 */
public class CustomTableRenderer extends DefaultTableCellRenderer{
    
    private static final long serialVersionUID = 1L;

   @Override 
   public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {

      Component c = super.getTableCellRendererComponent(table, value,
               isSelected, hasFocus, row, col);
      Object valueAt = table.getModel().getValueAt(row, col);
      String s = "";
      if (valueAt != null) {
         s = valueAt.toString();
      }

      if (s.equalsIgnoreCase("yellow")) {
         c.setForeground(Color.YELLOW);
         c.setBackground(Color.gray);
      } else {
         c.setForeground(Color.black);
         c.setBackground(Color.WHITE);
      }

      return c;
   }
}


