/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.Commands;

import EmailReader.GUI.AccountsListDialog;

/**
 *
 * @author Roman Nort
 */
public class ShowAccountsListCommand implements ICommand{

    public Boolean result;
    
    @Override
    public Boolean Execute() {
        
        AccountsListDialog accountsDialog = new AccountsListDialog(null, true);
        return true;
    }
    
    
    
}
