/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

/**
 *
 * @author Roman Nort
 */
public class Protocol
{
    public static String POP3 = "pop3";
    
    public static String POP3S = "pop3s";
    
    public static String IMAP = "imap";
    
    public static String IMAPS = "imaps";
    
    public static String SMTP = "smtp";
    
    public static String SMTPS = "smtps";
    
    /**
     * Google IMAP. Experimental protocol in JavaMail API
     */
    public static String GIMAP = "gimap";
    
    /**
     *  Empty protocol. =|
     */
    public static String NONE = "";
}