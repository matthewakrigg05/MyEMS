package UIs.Utilities;
import DB_Init.User;
import UIs.myEmsUI;

import javax.swing.*;
import java.awt.*;

public class employeesPanel extends JDialog {

    public static JPanel getEmployeePanel(User user){
        final JPanel employeesPanel = new JPanel();
        JLabel employeeTitle = new JLabel("Employees");
        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user);
            addEmployeeWindow.setTitle("Add a new employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return employeesPanel;
    }
}
