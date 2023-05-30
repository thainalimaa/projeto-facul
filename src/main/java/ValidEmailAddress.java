import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

/**
 *
 * @author thaina.matos
 */

public class ValidEmailAddress {
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } 
        catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
