package UIs.Utilities;

import javax.swing.*;

public class settingsPanel {

    public static JPanel getSettingsPanel(){
        final JPanel settingsPanel = new JPanel();
        JLabel settingsTitle = new JLabel("Settings");

        settingsPanel.add(settingsTitle);

        return settingsPanel;
    }
}
