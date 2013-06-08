/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.Authenticator;

/**
 *
 * @author Roman Nort
 */
public class MessagesProvider {

    private AccountData account;
    private Folder currentFolder;
    private Store currentStore;

    /**
     *
     */
    public MessagesProvider() {
        account = AccountData.ActiveAccount;
    }

    // protocol://username:password@host/foldername
    /**
     *
     * @return
     */
    public Message[] GetMessages() {

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account.Login, account.Password);
            }
        };

        Properties props = new Properties();
        String protocol = account.HostIn.Protocl;
        props.put("mail." + protocol + ".host", account.HostIn.Host);
        props.put("mail." + protocol + ".user", account.Login);
        props.put("mail.store.protocol", protocol);
        props.put("mail." + protocol + ".auth", "true");
        props.put("mail." + protocol + ".socketFactory", account.HostIn.Port);
        props.put("mail." + protocol + ".socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail." + protocol + ".port", account.HostIn.Port);

        try {

            // Connect to the server
            Session session = Session.getDefaultInstance(props, auth);
            Store store = session.getStore(protocol);
            store.connect();

            // Open the folder
            Folder inbox = store.getFolder("INBOX");

            if (inbox == null) {
                System.exit(1);
            }
            inbox.open(Folder.READ_WRITE);

            Message messages[] = inbox.getMessages();
            FetchProfile fp = ConfigureFetching();
            inbox.fetch(messages, fp);

            currentFolder = inbox;
            currentStore = store;

            return messages;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return
     */
    private FetchProfile ConfigureFetching() {
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        fp.add("X-mailer");
        return fp;
    }

    /**
     *
     */
    public void CloseConnection() {
        try {
            currentFolder.close(true);
            currentStore.close();
        } catch (MessagingException ex) {
            Logger.getLogger(MessagesProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
