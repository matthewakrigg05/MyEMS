package UnitTesting;

import DB_Usage.passwordUtils;
import DB_Usage.validRegistration;
import org.junit.jupiter.api.Test;

class registrationTest extends passwordUtils {

    //Example emails for invalidEmailAddress():
    String [] validEmails = new String[]{"example@email.com",
    "example.first.middle.lastname@email.com",
    "example@subdomain.email.com",
    "example+firstname+lastname@email.com",
    "example@234.234.234.234",
    "example@[234.234.234.234]",
    "       “example”@email.com",
    "0987654321@example.com",
    "example@email-one.com",
    "_______@email.com",
    "example@email.name",
    "example@email.museum",
    "example@email.co.jp",
    "example.firstname-lastname@email.com",
    "Valid Email Addresses that appear at glance to be invalid",
    "extremely.”odd\\unusual”@example.com",
    "extremely.unusual.”@”.unusual.com@example.com",
    "very.”(),:;<>[]”.VERY.”very@\\\\ “very”.unusual@strange.email.example.com"};

    //Boolean emailsAreValid = False;

    @Test
    void invalidEmailAddress() {
        int i = 0;
        for (String email : validEmails){
            i++;

            if(validRegistration.invalidEmailAddress(email)){
                System.out.println("Test " + i + " Unsuccessful - valid email address not accepted.");
            }
            else {
                System.out.println("Test " + i + " Successful - valid email address correctly accepted.");
            }
        }
    }

    @Test
    void invalidPassword() {
    }

    @Test
    void validateRegistrationInput() {
    }
}