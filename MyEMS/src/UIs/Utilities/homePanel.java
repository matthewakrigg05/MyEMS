package UIs.Utilities;
import javax.swing.*;

public class homePanel {

    public static JPanel getHomePanel(){

        // Components associated with the home panel
        final JPanel homePanel = new JPanel();
        JButton button = new JButton();
        JLabel homeTitle = new JLabel("Main content");

        homePanel.add(button);
        homePanel.add(homeTitle);

        return homePanel;
    }

}
