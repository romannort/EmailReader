/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import EmailReader.GUI.MainForm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author r.ilyenko
 */
public class CustomTableRenderer extends DefaultTableCellRenderer {

    private Message[] messages;
    
    
    public CustomTableRenderer(Message[] messages){
        this.messages = messages;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object color,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component c = super.getTableCellRendererComponent(table, color,
                isSelected, hasFocus, row, column);
        try {
            if (messages != null && messages[column].isSet(Flags.Flag.SEEN)) {
                c.setFont(c.getFont().deriveFont(Font.PLAIN));
            } else {
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            }

        } catch (MessagingException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
}
