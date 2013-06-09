/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import EmailReader.GUI.MainForm;

/**
 *
 * @author Roman Nort
 */
public class EmailReader 
{
    
    
    public static void main(String[] args)
    {
        ShowForm();
    }
    
    private static void ShowForm()
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater( new Runnable() 
        {
            @Override
            public void run() 
            {
                new MainForm().setVisible(true);
            }
        });
    }
}
