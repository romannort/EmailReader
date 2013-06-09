/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.Core;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Roman Nort
 */
public class CustomPasswordAuthenticator extends Authenticator {

    /**
     * 
     */
    private AccountData account;
    
    /**
     * 
     */
    public CustomPasswordAuthenticator(){
        account = AccountData.ActiveAccount;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(account.Login, account.Password);
    }
}
