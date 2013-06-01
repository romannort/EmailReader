/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author r.ilyenko
 */
public class CustomTableModel extends AbstractTableModel {

    private Message[] messages;
    private String[] columnHeadrs = {"Date", "From", "To", "Subject"};

    
       
    public CustomTableModel(List<Message[]> messages){
        this.messages = messages.get(0);
    }
    
    @Override
    public String getColumnName(int col) {
        return columnHeadrs[col];
    }

    @Override
    public int getRowCount() {
        return messages.length;
    }

    @Override
    public int getColumnCount() {
        return columnHeadrs.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            if (row >= 0 && row < getRowCount()) {
                switch (col) {
                    case 0:
                        return DateFormatter.Format(messages[row].getReceivedDate());
                    case 1:
                        return MessageAddressFormatter.Format(messages[row].getFrom());
                    case 2:
                        return MessageAddressFormatter.Format(messages[row].getRecipients(Message.RecipientType.TO));
                    case 3:
                        return messages[row].getSubject();
                    default:
                        return "";
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * All cells are immutable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
