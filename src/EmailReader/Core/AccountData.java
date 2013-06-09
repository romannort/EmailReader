package EmailReader.Core;

/**
 * Account data fields.
 * @author Roman Nort
 */
public class AccountData implements java.io.Serializable {
    
    /**
     * Current active account
     */
    public static AccountData ActiveAccount;
    
    public String Login;
    
    public String Password;
    
    public String PasswordConfirmation;
    
    public HostConnection HostIn;
    
    public HostConnection HostOut;
    
    /**
     * Default c-tor
     */
    public AccountData()
    {
        Login = "";
        Password = "";
        PasswordConfirmation = "";
        HostIn = new HostConnection();
        HostOut = new HostConnection();
    }
    
    
    @Override
    public String toString()
    {
        return this.Login;
    }
}
