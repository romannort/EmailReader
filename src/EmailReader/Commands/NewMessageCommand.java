/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader.Commands;

/**
 *
 * @author Roman Nort
 */
public class NewMessageCommand implements ICommand{

    
    public NewMessageCommand(){
        
    }
    
    @Override
    public Boolean Execute() {
        return true;
    }
    
}
