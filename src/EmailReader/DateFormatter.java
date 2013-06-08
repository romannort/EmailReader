package EmailReader;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Roman Nort
 */
public class DateFormatter {

    /**
     * 
     */
    private static SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * 
     * @param date
     * @return 
     */
    public static String Format(Date date) {
        String dateOut;
        dateOut = simpleFormat.format(date);
        return dateOut;
    }
}
