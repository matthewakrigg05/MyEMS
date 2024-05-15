package DB_Init;

public class validRegistration {

    public static boolean validateEmailAddress(String email){
        String emailPatterns = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailPatterns);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validPassword(String password) {
        String MIN_LENGTH = "6";
        String MAX_LENGTH = "25";
        String ONE_DIGIT = "(?=.*[0-9])";
        String SPECIAL_CHAR = "(?=.*[@#$%^&+=])";
        String NO_SPACE = "(?=\\S+$)";

        String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";
        String PATTERN = ONE_DIGIT + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;

        return password.matches(PATTERN);
    }

    public static boolean validateRegistrationInput(String email, String password, String rePassword){
        if(email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) return false;

        if(!validRegistration.validPassword(password)) return false;

        if(!validRegistration.validateEmailAddress(email)) return false;

        return password.equals(rePassword);
    }
}
