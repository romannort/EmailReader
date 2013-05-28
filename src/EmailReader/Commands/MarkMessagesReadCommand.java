/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.Commands;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 *
 * @author Roman Nort
 */
public class MarkMessagesReadCommand implements ICommand {

    private List<Message> selectedMessages;
    private boolean read;

    public MarkMessagesReadCommand( List<Message> selectedMessages, boolean read) {
        this.selectedMessages = selectedMessages;
        this.read = read;
    }

    @Override
    public Boolean Execute() {
        try {
            for (int i = 0; i < selectedMessages.size(); ++i) {
                selectedMessages.get(i).setFlag(Flags.Flag.SEEN, read);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(MarkMessagesReadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
