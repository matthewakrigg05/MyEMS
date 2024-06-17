package UIs;
import DB_Usage.User;
import UIs.Utilities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

// File for the main UI of the application, sidebar does not have its own utility file due to the need for it to be
// able to directly interact with the frame.

public class myEmsUI extends mainFrame implements ActionListener {

    public myEmsUI(User user) throws IOException {
        super(user, "MyEMS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public myEmsUI() throws IOException{
        super("My EMS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    protected void addUIcomponents() {
        add(homePanel.getHomePanel(), BorderLayout.CENTER);
        add(sideBar.getSideBar(user, this), BorderLayout.WEST);
    }
}