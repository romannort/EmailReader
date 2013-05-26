/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 *
 * @author Roman Nort
 */
public class MessageView {

    private int msgnum;
    private Address[] from;
    private Date receivedDate;
    private Address[] recipients;
    private String subject;

    public MessageView(Message m)
    {
        msgnum = m.getMessageNumber();
        try {
            from = m.getFrom();
            receivedDate = m.getReceivedDate();
            recipients = m.getAllRecipients();
            subject = m.getSubject();
        } catch (MessagingException ex) {
            Logger.getLogger(MessageView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Date getReceivedDate() {
    
        return receivedDate;
    }

    public String getFrom() {
        return from.toString();
    }

    public String getRecipients() {
    
        return recipients.toString();
    }

    public String getSubject() {
        return subject;
    }
}
