/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailReader;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Roman Nort
 */
public class DateFormatter {

    private static DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
    
    public static String Format(Date date) {
        String dateOut;
        dateOut = dateFormatter.format(date);
        return dateOut;
    }
}
