package UIs.Utilities;
import DB_Usage.User;
import DB_Usage.employeeInfo;
import UIs.myEmsUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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

        DefaultTableModel tableModel = new DefaultTableModel(employeeInfo.getEmployeeInfo(user), employeeInfo.getColumnNames());
        JTable table = new JTable(tableModel);
        table.setEnabled(false);

        employeesPanel.add(employeeTitle);
        employeesPanel.add(addEmployeeLabel);
        employeesPanel.add(addEmployeeButton);
        employeesPanel.add(table);

        addEmployeeButton.addActionListener(e -> {
            JDialog addEmployeeWindow = new addEmployeeWindow(user, myEmsUi, employeesPanel, tableModel);
            addEmployeeWindow.setTitle("Add a new employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return scrollPane;
    }
}
