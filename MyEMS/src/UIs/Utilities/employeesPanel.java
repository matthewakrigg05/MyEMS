package UIs.Utilities;
import javax.swing.*;
import java.awt.*;

public class employeesPanel {

    public static JPanel getEmployeePanel(){
        final JPanel employeesPanel = new JPanel();
        JLabel employeeTitle = new JLabel("Employees");
        JLabel addEmployeeLabel = new JLabel("Add Employee");
        JButton addEmployeeButton = new JButton("+");

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);

        JWindow addEmployeeWindow = addEmployeeWindow(employeesPanel);
        addEmployeeButton.addActionListener(e -> addEmployeeWindow.setVisible(true));

        return employeesPanel;
    }

    // This is the window that opens when the add employee button is pressed to input the employees' information
    public static JWindow addEmployeeWindow(JPanel employeesPanel){
        JWindow addEmployeeWindow = new JWindow();
        JPanel addEmployeePanel = new JPanel();
        JButton closeWindow = new JButton("x");
        JLabel addEmployeeLabel = new JLabel("Add Employee");

        addEmployeeWindow.setVisible(false);
        addEmployeeWindow.setSize(200, 200);
        addEmployeeWindow.setLocationRelativeTo(employeesPanel);
        addEmployeeWindow.add(addEmployeePanel);

        addEmployeePanel.setBackground(Color.GRAY);
        addEmployeePanel.add(closeWindow);
        addEmployeePanel.add(addEmployeeLabel);

        closeWindow.addActionListener(e -> addEmployeeWindow.setVisible(false));

        return addEmployeeWindow;
    }
}
