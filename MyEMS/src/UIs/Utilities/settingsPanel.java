package UIs.Utilities;
import UIs.logInUI;
import UIs.myEmsUI;
import javax.swing.*;
import java.io.IOException;

public class settingsPanel {

    public static JPanel getSettingsPanel(myEmsUI myEmsUI){
        final JPanel settingsPanel = new JPanel();
        JLabel settingsTitle = new JLabel("Settings");
        JButton logOutButton = new JButton("Log Out");

        settingsPanel.add(settingsTitle);
        settingsPanel.add(logOutButton);

        logOutButton.addActionListener(e -> {
            try {
                new logInUI().setVisible(true);

                myEmsUI.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        return settingsPanel;
    }
}
