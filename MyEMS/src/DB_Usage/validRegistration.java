package DB_Usage;
import java.awt.*;

/*
The validRegistration class is a utility class of static methods that are used when checking the user input, ensuring
that said input is valid and meets specific requirements.
 */

public class validRegistration extends Component {

    // Uses a regex pattern to determine whether an email address is invalid, if so returns true, therefore
    // returning false if the email is valid
    public static boolean invalidEmailAddress(String email) {
        String emailPatterns = "^[a-zA-Z0-9.\"!#$%&'*\\\\@+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailPatterns);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    // Password requirements using regex patterns.
    public static boolean invalidPassword(String password) {
        String MIN_LENGTH = "6";
        String MAX_LENGTH = "25";
        String ONE_DIGIT = "(?=.*[0-9])";
        String SPECIAL_CHAR = "(?=.*[@#$%^&+=])";
        String NO_SPACE = "(?=\\S+$)";
        String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";
        String PATTERN = ONE_DIGIT + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;
        return password.matches(PATTERN);
    }

    public static boolean validateRegistrationInput(String email, String password, String rePassword) {
        if (email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) return false;
        if (invalidPassword(password)) return false;
        if (invalidEmailAddress(email)) return false;

        return password.equals(rePassword);
    }
}