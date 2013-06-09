package EmailReader.Core;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.NewsAddress;

/**
 *
 * @author Roman Nort
 */
public class MessageAddressFormatter {

    /**
     * 
     * @param ads
     * @return 
     */
    public static String Format(Address[] ads) {

        String result = "";
        if (ads != null && ads.length > 0) {
            result = ParseSingleAddress(ads[0]);
        }
        return result;
    }

    /**
     * 
     * @param ads
     * @return 
     */
    public static String ParseSingleAddress(Address ads) {
        String result = "";
        if (ads != null) {
            if (ads instanceof InternetAddress) {
                result = ((InternetAddress) ads).getAddress();
            } else {
                if (ads instanceof NewsAddress) {
                    result = ((NewsAddress) ads).getHost();
                }
            }
        }
        return result;
    }

    /**
     * 
     * @param addresses
     * @return 
     */
    public static String FormatAll(Address[] addresses) {
        StringBuilder sb = new StringBuilder();
        for (Address a : addresses) {
            sb.append(',');
            sb.append(ParseSingleAddress(a));
        }
        return sb.substring(1);
    }
}
