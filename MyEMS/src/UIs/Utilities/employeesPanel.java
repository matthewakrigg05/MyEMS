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
        windowGrid.rowHeights = new int[]{30, 50, 100, 50, 100, 50, 100, 50, 100, 30};
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
        gbc_addEmployeeButton.gridy = 9;

        JLabel firstNameLabel = new JLabel("First Name: ");
        GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
        gbc_firstNameLabel.gridx = 1;
        gbc_firstNameLabel.gridy = 1;

        JTextField firstName = new JTextField();
        GridBagConstraints gbc_firstName = new GridBagConstraints();
        gbc_firstName.gridx = 1;
        gbc_firstName.gridy = 2;

        JLabel lastNameLabel = new JLabel("Last Name: ");
        GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
        gbc_lastNameLabel.gridx = 3;
        gbc_lastNameLabel.gridy = 1;

        JTextField lastName = new JTextField();
        GridBagConstraints gbc_lastName = new GridBagConstraints();
        gbc_lastName.gridx = 3;
        gbc_lastName.gridy = 2;

        JLabel emailLabel = new JLabel("Email: ");
        GridBagConstraints gbc_emailLabel = new GridBagConstraints();
        gbc_emailLabel.gridx = 1;
        gbc_emailLabel.gridy = 3;

        JTextField email = new JTextField();
        GridBagConstraints gbc_email = new GridBagConstraints();
        gbc_email.gridx = 1;
        gbc_email.gridy = 4;

        JLabel phoneNumLabel = new JLabel("Phone Number: ");
        GridBagConstraints gbc_phoneNumLabel = new GridBagConstraints();
        gbc_phoneNumLabel.gridx = 3;
        gbc_phoneNumLabel.gridy = 3;

        JTextField phoneNum = new JTextField();
        GridBagConstraints gbc_phoneNum = new GridBagConstraints();
        gbc_phoneNum.gridx = 3;
        gbc_phoneNum.gridy = 4;

        JLabel addressLabel = new JLabel("Address (House Number, Postcode): ");
        GridBagConstraints gbc_addressLabel = new GridBagConstraints();
        gbc_addressLabel.gridx = 1;
        gbc_addressLabel.gridy = 5;

        JTextField address = new JTextField();
        GridBagConstraints gbc_address = new GridBagConstraints();
        gbc_address.gridx = 1;
        gbc_address.gridy = 6;

        JLabel NInumLabel = new JLabel("National Insurance Number: ");
        GridBagConstraints gbc_NInumLabel = new GridBagConstraints();
        gbc_NInumLabel.gridx = 3;
        gbc_NInumLabel.gridy = 5;

        JTextField NInum = new JTextField();
        GridBagConstraints gbc_NInum = new GridBagConstraints();
        gbc_NInum.gridx = 3;
        gbc_NInum.gridy = 6;

        JLabel wageLabel = new JLabel("Wage/Salary: ");
        GridBagConstraints gbc_wageLabel = new GridBagConstraints();
        gbc_wageLabel.gridx = 1;
        gbc_wageLabel.gridy = 7;

        JTextField wage = new JTextField();
        GridBagConstraints gbc_wage = new GridBagConstraints();
        gbc_wage.gridx = 1;
        gbc_wage.gridy = 8;

        addEmployeeWindow.setVisible(false);
        addEmployeeWindow.setSize(1300, 750);
        addEmployeeWindow.setLocationRelativeTo(employeesPanel);
        addEmployeeWindow.add(addEmployeePanel);
        addEmployeePanel.setBackground(Color.GRAY);

        addEmployeePanel.add(addEmployeeLabel, gbc_addEmployeeLabel);
        addEmployeePanel.add(closeWindow, gbc_closeWindow);
        addEmployeePanel.add(firstNameLabel, gbc_firstNameLabel);
        addEmployeePanel.add(firstName, gbc_firstName);
        addEmployeePanel.add(lastNameLabel,gbc_lastNameLabel);
        addEmployeePanel.add(lastName, gbc_lastName);
        addEmployeePanel.add(emailLabel, gbc_emailLabel);
        addEmployeePanel.add(email, gbc_email);
        addEmployeePanel.add(phoneNumLabel, gbc_phoneNumLabel);
        addEmployeePanel.add(phoneNum, gbc_phoneNum);
        addEmployeePanel.add(addressLabel, gbc_addressLabel);
        addEmployeePanel.add(address, gbc_address);
        addEmployeePanel.add(NInumLabel, gbc_NInumLabel);
        addEmployeePanel.add(NInum, gbc_NInum);
        addEmployeePanel.add(wageLabel, gbc_wageLabel);
        addEmployeePanel.add(wage, gbc_wage);

        addEmployeePanel.add(addEmployeeButton, gbc_addEmployeeButton);

        closeWindow.addActionListener(e -> addEmployeeWindow.dispose());

        return addEmployeeWindow;
    }
}
