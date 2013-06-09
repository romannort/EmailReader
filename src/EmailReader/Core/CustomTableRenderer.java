package EmailReader.Core;

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
 * @author Roman Nort
 */
public class CustomTableRenderer extends DefaultTableCellRenderer {

    private JTable table;

    public CustomTableRenderer(JTable table) {
        this.table = table;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object color,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component c = super.getTableCellRendererComponent(table, color,
                isSelected, hasFocus, row, column);
        try {
            CustomTableModel model = (CustomTableModel) this.table.getModel();
            Message message = (Message) model.getMessageFromRow(row);
            int font = Font.BOLD;
            if (message != null && message.isSet(Flags.Flag.SEEN)) {
                font = Font.PLAIN;
            }
            c.setFont(c.getFont().deriveFont(font));
            Color bcolor = Color.WHITE;
            if (table.getSelectedRow() == row) {
                bcolor = Color.YELLOW;
            }
            c.setBackground(bcolor);
            c.setForeground(Color.BLACK);
        } catch (MessagingException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
}
