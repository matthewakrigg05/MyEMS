import DB_Init.User;
import UIs.logInUI;
import UIs.myEmsUI;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        SwingUtilities.invokeLater(Main::setLabelFont);

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    new logInUI().setVisible(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

//                try {
//                    new myEmsUI(new User(1, "generic@email.com", "password")).setVisible(true);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }

            }
        });
    }

    //Modified all label fonts, can still be re-modified in the UIs.EmsUI class
//    private static void setLabelFont() {
//        Font labelFont = new Font("Serif", Font.PLAIN, 14); // Customize as needed
//        UIManager.put("Label.font", labelFont);
//    }
}
