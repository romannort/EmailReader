/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.Commands;

import EmailReader.AccountData;
import EmailReader.GUI.AccountsListDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman Nort
 */
public class ShowAccountsListCommand implements ICommand {

    public Boolean result;
    private List<AccountData> accounts;
    private static String fileName = "accounts.dat";
    private static boolean firstRun = true;
    
    @Override
    public Boolean Execute() {

        
        ReadAccounts();
        
        AccountsListDialog accountsDialog = new AccountsListDialog(accounts, null, true);
        accountsDialog.setVisible(true);
        if (accountsDialog.getResult()) {
            result = true;
            accounts = accountsDialog.GetAccounts();
            WriteAccounts();
        }
        result = false;
        return result;
    }

    private void ReadAccounts() 
    {
        try {
            FileInputStream fileIn =
                    new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            accounts = (ArrayList<AccountData>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }

    private boolean WriteAccounts() {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(fileName);
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(accounts);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return true;
    }
}
