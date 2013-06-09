package EmailReader.Commands;

import EmailReader.GUI.NewMessageDialog;
import EmailReader.Core.NewMessageData;
import EmailReader.Core.SessionProviderSingleton;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Roman Nort
 */
public class NewMessageCommand implements ICommand {

    
    /**
     * 
     * @return 
     */
    @Override
    public Boolean Execute() {
        NewMessageData messageData;
        NewMessageDialog dialog = new NewMessageDialog(null, true);
        dialog.setVisible(true);
        if (dialog.IsSend()) {
            try {
                messageData = dialog.GetData();
                Session session = SessionProviderSingleton.GetSession();
                MimeMessage message = new MimeMessage(session);
                messageData.PopulateMimeMessage(message);
                Transport.send(message);
                return true;
            } catch (MessagingException ex) {
                Logger.getLogger(NewMessageCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
