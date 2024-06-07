package UIs.Utilities;
import DB_Usage.Employee;
import DB_Usage.User;
import UIs.myEmsUI;

import javax.swing.*;

import java.util.ArrayList;

import static DB_Usage.employeesDB.getEmployees;

public class employeesPanel extends JDialog {

    public static JScrollPane getEmployeePanel(User user, myEmsUI myEmsUi){
        final JPanel employeesPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(employeesPanel);
        employeesPanel.setAutoscrolls(true);

        ArrayList<Employee> employees = getEmployees(user);
        int numOfEmployees = employees.size();

        for(int i = 0; i < numOfEmployees; i++){
            String fname = employees.get(i).getFname();



            JTextArea employeeInfo = new JTextArea(fname);
            employeesPanel.add(employeeInfo);
        }

        JLabel employeeTitle = new JLabel("Employees");

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");
        JButton editEmployeesButton = new JButton("Edit");

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user, myEmsUi);
            addEmployeeWindow.setTitle("Add a new DB_Usage.employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return scrollPane;
    }
}
