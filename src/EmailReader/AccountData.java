package EmailReader;

/**
 * Account data fields.
 * @author Roman Nort
 */
public class AccountData {
    
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
    
}
