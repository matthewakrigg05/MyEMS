package UIs.Utilities;
import javax.swing.*;

public class rotasPanel {

    public rotasPanel(){}

    public static JPanel getRotasPanel(){
        // Components for the rotas panel
        final JPanel rotasPanel = new JPanel();
        JLabel rotasTitle = new JLabel("Rotas");

        rotasPanel.add(rotasTitle);

        return rotasPanel;
    }
}
