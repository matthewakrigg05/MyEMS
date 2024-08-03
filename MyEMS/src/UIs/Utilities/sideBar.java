package UIs.Utilities;
import DB_Usage.User;
import UIs.myEmsUI;
import javax.swing.*;
import java.awt.*;

public class sideBar {

    public static JToolBar getSideBar(User user, myEmsUI myEmsUI){
        JToolBar sideBar = new JToolBar(JToolBar.VERTICAL);
        JLabel sideBarTitle = new JLabel("MyEMS");
        JButton homeButton = new JButton("Home");
        JButton employeesButton = new JButton("Employees");
        JButton rotasButton = new JButton("Rotas");
        JButton calendarButton = new JButton("Calendar");
        JButton settingsButton = new JButton("Settings");

        sideBar.setBackground(Color.blue);
        sideBar.setPreferredSize(new Dimension(240, 500));
        sideBar.setFloatable(false);
        sideBar.add(sideBarTitle);
        sideBar.add(homeButton);
        sideBar.add(employeesButton);
        sideBar.add(rotasButton);
        sideBar.add(calendarButton);
        sideBar.add(settingsButton);

        homeButton.addActionListener(e -> {
            myEmsUI.getContentPane().removeAll();
            myEmsUI.getContentPane().add(sideBar, BorderLayout.WEST);
            myEmsUI.getContentPane().add(homePanel.getHomePanel(), BorderLayout.CENTER);
            myEmsUI.revalidate();
            myEmsUI.repaint();
        });

        employeesButton.addActionListener(e -> {
            myEmsUI.getContentPane().removeAll();
            myEmsUI.getContentPane().add(sideBar, BorderLayout.WEST);
            myEmsUI.getContentPane().add(employeesPanel.getEmployeePanel(user, myEmsUI), BorderLayout.CENTER);
            myEmsUI.revalidate();
            myEmsUI.repaint();
        });

        rotasButton.addActionListener(e -> {
            myEmsUI.getContentPane().removeAll();
            myEmsUI.getContentPane().add(sideBar, BorderLayout.WEST);
            myEmsUI.getContentPane().add(rotasPanel.getRotasPanel(), BorderLayout.CENTER);
            myEmsUI.revalidate();
            myEmsUI.repaint();
        });

        calendarButton.addActionListener(e -> {
            myEmsUI.getContentPane().removeAll();
            myEmsUI.getContentPane().add(sideBar, BorderLayout.WEST);
            myEmsUI.getContentPane().add(calendarPanel.getCalendarPanel(), BorderLayout.CENTER);
            myEmsUI.revalidate();
            myEmsUI.repaint();
        });

        settingsButton.addActionListener(e -> {
            myEmsUI.getContentPane().removeAll();
            myEmsUI.getContentPane().add(sideBar, BorderLayout.WEST);
            myEmsUI.getContentPane().add(settingsPanel.getSettingsPanel(myEmsUI), BorderLayout.CENTER);
            myEmsUI.revalidate();
            myEmsUI.repaint();
        });

        return sideBar;
    }

}
