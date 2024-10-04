import UIs.logInUI;
import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new logInUI();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}