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

        GridBagLayout windowGrid = new GridBagLayout();
        windowGrid.columnWidths = new int[]{50, 500, 150, 500, 50};
        windowGrid.rowHeights = new int[]{30, 150, 150, 150, 150, 30};
        addEmployeePanel.setLayout(windowGrid);

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        GridBagConstraints gbc_addEmployeeLabel = new GridBagConstraints();
        gbc_addEmployeeLabel.gridx = 2;
        gbc_addEmployeeLabel.gridy = 0;

        JButton closeWindow = new JButton("Cancel");
        GridBagConstraints gbc_closeWindow = new GridBagConstraints();
        gbc_closeWindow.gridx = 4;
        gbc_closeWindow.gridy = 0;
        gbc_closeWindow.fill = GridBagConstraints.HORIZONTAL;

        JButton addEmployeeButton = new JButton("Add");
        GridBagConstraints gbc_addEmployeeButton = new GridBagConstraints();
        gbc_addEmployeeButton.gridx = 2;
        gbc_addEmployeeButton.gridy = 5;



        addEmployeeWindow.setVisible(false);
        addEmployeeWindow.setSize(1300, 700);
        addEmployeeWindow.setLocationRelativeTo(employeesPanel);
        addEmployeeWindow.add(addEmployeePanel);
        addEmployeePanel.setBackground(Color.GRAY);

        addEmployeePanel.add(addEmployeeLabel, gbc_addEmployeeLabel);
        addEmployeePanel.add(closeWindow, gbc_closeWindow);



        addEmployeePanel.add(addEmployeeButton, gbc_addEmployeeButton);

        closeWindow.addActionListener(e -> addEmployeeWindow.dispose());

        return addEmployeeWindow;
    }
}
