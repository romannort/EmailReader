package EmailReader;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;

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

        String protocol = account.HostIn.Protocl;
        try {

            // Connect to the server
            Session session = SessionProviderSingleton.GetSession();
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
        fp.add(FetchProfile.Item.FLAGS);
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
