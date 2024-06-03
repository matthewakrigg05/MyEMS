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
        // Components associated to the side-bar:
        final JToolBar sideBar = new JToolBar(JToolBar.VERTICAL);
        JLabel placeholder = new JLabel("MyEMS");
        JButton homeButton = new JButton("Home");
        JButton employeesButton = new JButton("Employees");
        JButton rotasButton = new JButton("Rotas");
        JButton calendarButton = new JButton("Calendar");
        JButton settingsButton = new JButton("Settings");

        sideBar.setBackground(Color.blue);
        sideBar.setPreferredSize(new Dimension(240, 500));
        sideBar.setFloatable(false);
        sideBar.add(placeholder);
        sideBar.add(homeButton);
        sideBar.add(employeesButton);
        sideBar.add(rotasButton);
        sideBar.add(calendarButton);
        sideBar.add(settingsButton);

        // Action Listeners for the sidebar buttons, removes all panels then replaces them with the panels they
        // intend to see
        homeButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(homePanel.getHomePanel(), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        employeesButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(employeesPanel.getEmployeePanel(user, this), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        rotasButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(rotasPanel.getRotasPanel(), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        calendarButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(calendarPanel.getCalendarPanel(), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        settingsButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(settingsPanel.getSettingsPanel(), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        add(homePanel.getHomePanel(), BorderLayout.CENTER);
        add(sideBar, BorderLayout.WEST);
    }
}