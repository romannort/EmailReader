/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

/**
 *
 * @author Roman Nort
 */
public class HostConnection implements java.io.Serializable
{
           
    public String Host;
    
    public String Port;
    
    public Boolean Ssl;
    
    public Boolean Tls;
    
    public String Protocl;
    
    
    public HostConnection()
    {
        Host = "";
        Port = "";
        Ssl = false;
        Tls = false;
        Protocl = Protocol.NONE;
    }
}