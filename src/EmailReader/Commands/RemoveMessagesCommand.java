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
public class RemoveMessagesCommand implements ICommand {

    private List<Message> selectedMessages;

    /**
     *
     * @param selectedMessages
     */
    public RemoveMessagesCommand(List<Message> selectedMessages) {
        this.selectedMessages = selectedMessages;
    }

    @Override
    public Boolean Execute() {
        try {
            for (Message m : selectedMessages) {

                m.setFlag(Flags.Flag.DELETED, true);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(RemoveMessagesCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
