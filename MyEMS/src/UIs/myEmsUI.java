package UIs;
import DB_Init.User;
import UIs.Utilities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;


public class myEmsUI extends mainFrame implements ActionListener {

    public myEmsUI(User user) throws IOException {
        super("MyEMS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public myEmsUI() throws IOException{
        super("My EMS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    protected void addUIcomponents() {

        // Components for the rotas panel
        final JPanel rotasPanel = new JPanel();
        JLabel rotasTitle = new JLabel("Rotas");

        // Components for the calendar panel
        final JPanel calendarPanel = new JPanel();
        JLabel calendarTitle = new JLabel("Calendar");

        final JPanel settingsPanel = new JPanel();
        JLabel settingsTitle = new JLabel("Settings");

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

        rotasPanel.add(rotasTitle);

        calendarPanel.add(calendarTitle);

        settingsPanel.add(settingsTitle);

        add(homePanel.getHomePanel(), BorderLayout.CENTER);
        add(sideBar, BorderLayout.WEST);

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
            getContentPane().add(employeesPanel.getEmployeePanel(), BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        rotasButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(rotasPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        calendarButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(calendarPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        settingsButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(sideBar, BorderLayout.WEST);
            getContentPane().add(settingsPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });
    }
}