package UIs.Utilities;
import DB_Usage.Employee;
import DB_Usage.User;
import UIs.myEmsUI;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Date;

import static DB_Usage.employeesDB.getEmployees;

public class employeesPanel extends JDialog {

    public static JScrollPane getEmployeePanel(User user, myEmsUI myEmsUi){
        final JPanel employeesPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(employeesPanel);
        employeesPanel.setAutoscrolls(true);

        JLabel employeeTitle = new JLabel("Employees");

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");
        JButton editEmployeesButton = new JButton("Edit");

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);

        ArrayList<Employee> employees = getEmployees(user);
        int numOfEmployees = employees.size();

        for(int i = 0; i < numOfEmployees; i++){
            int employeeId = employees.get(i).getEmployeeId();
            String fname = employees.get(i).getFname();
            String lname = employees.get(i).getLname();
            String email = employees.get(i).getEmail();
            String phoneNum = employees.get(i).getPhoneNum();
            String address = employees.get(i).getAddress();
            String NInum = employees.get(i).getNInumber();
            float wage = employees.get(i).getWage();
            float hours = employees.get(i).getHoursWorked();
            Date dateJoined = employees.get(i).getJoinDate();

            JTextArea employeeInfo = new JTextArea(employeeId + " " + fname + " " + lname + " " + email + " " +
                    phoneNum + " " + address + " " + NInum + " " + wage + " " + hours + " " + dateJoined);
            employeeInfo.setEditable(false);
            employeeInfo.setOpaque(false);
            employeesPanel.add(employeeInfo);
        }

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user, myEmsUi);
            addEmployeeWindow.setTitle("Add a new DB_Usage.employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return scrollPane;
    }
}
