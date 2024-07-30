package UnitTesting;
import DB_Usage.passwordUtils;
import DB_Usage.validRegistration;
import org.junit.jupiter.api.Test;

class registrationTests extends passwordUtils {

    //Example valid emails for invalidEmailAddress():
    String [] validEmails = new String[]{
            "example@email.com",
            "example.first.middle.lastname@email.com",
            "example@subdomain.email.com",
            "example+firstname+lastname@email.com",
            "\"example\"@email.com",
            "0987654321@example.com",
            "example@email-one.com",
            "_______@email.com",
            "example@email.name",
            "example@email.museum",
            "example@email.co.jp",
            "example.firstname-lastname@email.com",
            "extremely.\"odd\\unusual\"@example.com",
            "extremely.unusual.\"@\".unusual.com@example.com",
            "example@[234.234.234.234]"};

    // Examples invalid emails for invalidEmailAddress()
    String [] invalidEmails = new String[]{
            "plaintextaddress",
            "@email.com",
            "@#@@##@%^%#$@#$@#.com",
            "John Doe <example@email.com>",
            "example.email.com",
            "        .example@email.com",
            "        example…example@email.com",
            "おえあいう@example.com",
            "example@email.com (John Doe)",
            "example@email",
            "example@111.222.333.44444",
            "example@email…com",
            "CAT…123@email.com",
            "”(),:;<>[\\]@email.com",
            "obviously”not”correct@email.com",
            "example\\ is”especially”not\\allowed@email.com"};

    @Test
    void invalidEmailAddress() {
        int i = 0;
        for (String email : validEmails){
            i++;

            if(validRegistration.invalidEmailAddress(email)){
                System.out.println("Test Case: " + i + " " + email + " Unsuccessful - valid email address not accepted.");
            }
            else {
                System.out.println("Test Case: " + i + " Successful - valid email address correctly accepted.");
            }
        }

        for (String email : invalidEmails){
            i++;

            if(validRegistration.invalidEmailAddress(email)){
                System.out.println("Test Case: " + i + " Successful - invalid email address correctly not accepted.");
            }
            else {
                System.out.println("Test Case: " + i + " " + email + " Unsuccessful - valid email address incorrectly accepted.");
            }
        }
    }

    @Test
    void specEmail(){
        if(validRegistration.invalidEmailAddress("       “example”@email.com")){
            System.out.println("Valid");
        };
    }

    @Test
    void invalidPassword() {
    }

    @Test
    void validateRegistrationInput() {
    }
}