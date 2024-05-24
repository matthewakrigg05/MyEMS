package DB_Init;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.apache.commons.codec.binary.Hex;

/*
* Password hashing algorithm using PBKDF2 as found on medium article
* @ https://medium.com/@kasunpdh/how-to-store-passwords-securely-with-pbkdf2-204487f14e84
*/

public class passwordUtils {
    public static String hashPassword(String password) {
        int iterations = 10000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();
        byte[] salt = System.getenv("SALT").getBytes();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] hashedBytes = key.getEncoded( );
            return Hex.encodeHexString(hashedBytes);

        } catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }
}
