package EmailReader;

import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Roman Nort
 */
public class CustomTableModel extends AbstractTableModel {

    public Message[] messages;
    private String[] columnHeadrs = {"Date", "From", "To", "Subject"};

    public CustomTableModel(List<Message[]> messages) {
        if (messages != null) {
            this.messages = messages.get(0);
        } else {
            this.messages = new Message[0];
        }

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
     * 
     * @param row
     * @return 
     */
    public Message getMessageFromRow(int row) {
        return messages[row];
    }

    /**
     * All cells are immutable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
