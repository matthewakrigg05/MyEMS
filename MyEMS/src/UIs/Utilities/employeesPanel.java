package UIs.Utilities;
import DB_Usage.Employee;
import DB_Usage.User;
import UIs.myEmsUI;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import DB_Usage.employeesDB;

public class employeesPanel extends JDialog {

    public static JScrollPane getEmployeePanel(User user, myEmsUI myEmsUi){
        final JPanel employeesPanel = new JPanel();
        GridBagLayout employeesLayout = new GridBagLayout();
        employeesPanel.setLayout(employeesLayout);

        JScrollPane scrollPane = new JScrollPane(employeesPanel);
        employeesPanel.setAutoscrolls(true);

        JLabel employeeTitle = new JLabel("Employees");

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");

        ArrayList<Employee> employees = employeesDB.getEmployees(user);
        String[][] employeeInfo = new String[employees.size()][10];
        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Address", "NI", "Wage", "Hours", "Joined"};

        for (Employee employee : employees) {
            String employeeData = employee.getEmployeeData();

            employeeInfo[(employee.getEmployeeId() - 1)][0] = String.valueOf(employee.getEmployeeId());
            employeeInfo[(employee.getEmployeeId() - 1)][1] = employee.getFname();
            employeeInfo[(employee.getEmployeeId() - 1)][2] = employee.getLname();
            employeeInfo[(employee.getEmployeeId() - 1)][3] = employee.getEmail();
            employeeInfo[(employee.getEmployeeId() - 1)][4] = employee.getPhoneNum();
            employeeInfo[(employee.getEmployeeId() - 1)][5] = employee.getAddress();
            employeeInfo[(employee.getEmployeeId() - 1)][6] = employee.getNInumber();
            employeeInfo[(employee.getEmployeeId() - 1)][7] = String.valueOf(employee.getWage());
            employeeInfo[(employee.getEmployeeId() - 1)][8] = String.valueOf(employee.getHoursWorked());
            employeeInfo[(employee.getEmployeeId() - 1)][9] = String.valueOf(employee.getJoinDate());
        }

        JTable table = new JTable(employeeInfo, columnNames);
        table.setEnabled(false);

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);
        employeesPanel.add(table);

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user, myEmsUi);
            addEmployeeWindow.setTitle("Add a new employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return scrollPane;
    }
}
