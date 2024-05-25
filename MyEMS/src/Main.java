import UIs.logInUI;
import UIs.myEmsUI;
import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                new myEmsUI();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
