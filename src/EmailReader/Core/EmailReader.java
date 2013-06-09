package EmailReader.Core;

import EmailReader.GUI.MainForm;

/**
 *
 * @author Roman Nort
 */
public class EmailReader 
{
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        ShowForm();
    }
    
    /**
     * 
     */
    private static void ShowForm()
    {
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
