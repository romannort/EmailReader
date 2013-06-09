package EmailReader;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;

/**
 *
 * @author Roman Nort
 */
public class SessionProviderSingleton {

    private static volatile SessionProviderSingleton instance = null;
    private AccountData account;
    private Properties props;
    private Session session;
    private Authenticator authenticator;

    /**
     * 
     * @return 
     */
    public static Session GetSession() {
        if (instance == null) {
            synchronized (SessionProviderSingleton.class) {
                if (instance == null) {
                    instance = new SessionProviderSingleton();
                }
            }
        }
        return instance.GetSessionInternal();
    }

    /**
     * 
     */
    private SessionProviderSingleton() {
        account = AccountData.ActiveAccount;
        InitialiseProperties();
        authenticator = new CustomPasswordAuthenticator();
        session = Session.getDefaultInstance(props, authenticator);
    }

    /**
     * 
     */
    private void InitialiseProperties() {
        props = new Properties();
        String protocol = account.HostIn.Protocl;
        props.put("mail." + protocol + ".host", account.HostIn.Host);
        props.put("mail." + protocol + ".user", account.Login);
        props.put("mail.store.protocol", protocol);
        props.put("mail." + protocol + ".auth", "true");
        props.put("mail." + protocol + ".socketFactory", account.HostIn.Port);
        props.put("mail." + protocol + ".socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail." + protocol + ".port", account.HostIn.Port);

        props.put("mail.smtp.host", account.HostOut.Host);
        props.put("mail.smtp.socketFactory.port", account.HostOut.Port);
        if (account.HostOut.Ssl) {
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
        }
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", account.HostOut.Port);
    }

    /**
     * 
     * @return 
     */
    private Session GetSessionInternal() {
        return session;
    }
}
