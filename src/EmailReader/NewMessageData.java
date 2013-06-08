package EmailReader;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Roman Nort
 */
public class NewMessageData {

    public String To;
    public String Cc;
    public String Bcc;
    public String Subject;
    public String Content;

    /**
     *
     * @param msg
     */
    public void PopulateMimeMessage(MimeMessage msg) {
        try {
            msg.setFrom(new InternetAddress(AccountData.ActiveAccount.Login));
            msg.setRecipients(Message.RecipientType.TO, ToAddresses(To));
            msg.setRecipients(Message.RecipientType.CC, ToAddresses(Cc));
            msg.setRecipients(Message.RecipientType.BCC, ToAddresses(Bcc));
            msg.setSubject(Subject);
            msg.setSentDate(new Date());
            msg.setText(Content);
        } catch (MessagingException ex) {
            Logger.getLogger(NewMessageData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param s
     * @return
     */
    private String[] StringToArray(String s) {
        String[] result = s.split("\\s*,\\s*");
        return result;
    }

    /**
     *
     * @param s
     * @return
     * @throws AddressException
     */
    private InternetAddress[] ToAddresses(String s) throws AddressException {
        String[] array = StringToArray(s);
        InternetAddress[] addresses = new InternetAddress[array.length];
        for (int i = 0; i < array.length; ++i) {
            addresses[i] = new InternetAddress(array[i]);
        }
        return addresses;
    }
}
