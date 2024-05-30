package UIs.Utilities;
import DB_Usage.User;
import UIs.myEmsUI;

import javax.swing.*;

public class employeesPanel extends JDialog {

    public static JPanel getEmployeePanel(User user, myEmsUI myEmsUi){
        final JPanel employeesPanel = new JPanel();
        JLabel employeeTitle = new JLabel("Employees");

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");
        JButton editEmployeesButton = new JButton("Edit");

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user, myEmsUi);
            addEmployeeWindow.setTitle("Add a new employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return employeesPanel;
    }
}
