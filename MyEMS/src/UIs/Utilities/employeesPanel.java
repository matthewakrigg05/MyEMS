package UIs.Utilities;
import DB_Usage.User;
import DB_Usage.employeeInfo;
import DB_Usage.employeesDB;
import UIs.myEmsUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import static DB_Usage.employeesDB.validateInput;

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

        JDialog addEmployeeWindow = new JDialog();

        addEmployeeWindow.setFocusable(true);
        addEmployeeWindow.setSize(1300, 750);
        addEmployeeWindow.setModal(true);
        addEmployeeWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addEmployeeWindow.setResizable(false);
        addEmployeeWindow.setBackground(Color.gray);

        Dimension textFields = new Dimension(300, 40);
        Font textFieldFont = new Font(("Dialog"), Font.PLAIN, 20);

        GridBagLayout windowGrid = new GridBagLayout();
        windowGrid.columnWidths = new int[]{50, 500, 150, 500, 50};
        windowGrid.rowHeights = new int[]{30, 50, 100, 50, 100, 50, 100, 50, 100, 30};
        addEmployeeWindow.setLayout(windowGrid);

        JLabel addEmployeeWindowLabel = new JLabel("Add Employee");
        GridBagConstraints gbc_addEmployeeLabel = new GridBagConstraints();
        gbc_addEmployeeLabel.gridx = 2;
        gbc_addEmployeeLabel.gridy = 0;

        JButton addEmployeeWindowButton = new JButton("Add");
        GridBagConstraints gbc_addEmployeeButton = new GridBagConstraints();
        gbc_addEmployeeButton.gridx = 2;
        gbc_addEmployeeButton.gridy = 9;

        JLabel firstNameLabel = new JLabel("First Name: ");
        GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
        gbc_firstNameLabel.gridx = 1;
        gbc_firstNameLabel.gridy = 1;

        JTextField firstName = new JTextField();
        firstName.setPreferredSize(textFields);
        firstName.setFont(textFieldFont);
        GridBagConstraints gbc_firstName = new GridBagConstraints();
        gbc_firstName.gridx = 1;
        gbc_firstName.gridy = 2;

        JLabel lastNameLabel = new JLabel("Last Name: ");
        GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
        gbc_lastNameLabel.gridx = 3;
        gbc_lastNameLabel.gridy = 1;

        JTextField lastName = new JTextField();
        lastName.setPreferredSize(textFields);
        lastName.setFont(textFieldFont);
        GridBagConstraints gbc_lastName = new GridBagConstraints();
        gbc_lastName.gridx = 3;
        gbc_lastName.gridy = 2;

        JLabel emailLabel = new JLabel("Email: ");
        GridBagConstraints gbc_emailLabel = new GridBagConstraints();
        gbc_emailLabel.gridx = 1;
        gbc_emailLabel.gridy = 3;

        JTextField email = new JTextField();
        email.setPreferredSize(textFields);
        email.setFont(textFieldFont);
        GridBagConstraints gbc_email = new GridBagConstraints();
        gbc_email.gridx = 1;
        gbc_email.gridy = 4;

        JLabel phoneNumLabel = new JLabel("Phone Number: ");
        GridBagConstraints gbc_phoneNumLabel = new GridBagConstraints();
        gbc_phoneNumLabel.gridx = 3;
        gbc_phoneNumLabel.gridy = 3;

        JTextField phoneNum = new JTextField();
        phoneNum.setPreferredSize(textFields);
        phoneNum.setFont(textFieldFont);
        GridBagConstraints gbc_phoneNum = new GridBagConstraints();
        gbc_phoneNum.gridx = 3;
        gbc_phoneNum.gridy = 4;

        JLabel addressLabel = new JLabel("Address (House Number, Postcode): ");
        GridBagConstraints gbc_addressLabel = new GridBagConstraints();
        gbc_addressLabel.gridx = 1;
        gbc_addressLabel.gridy = 5;

        JTextField address = new JTextField();
        address.setFont(textFieldFont);
        address.setPreferredSize(textFields);
        GridBagConstraints gbc_address = new GridBagConstraints();
        gbc_address.gridx = 1;
        gbc_address.gridy = 6;

        JLabel NInumLabel = new JLabel("National Insurance Number: ");
        GridBagConstraints gbc_NInumLabel = new GridBagConstraints();
        gbc_NInumLabel.gridx = 3;
        gbc_NInumLabel.gridy = 5;

        JTextField NInum = new JTextField();
        NInum.setFont(textFieldFont);
        NInum.setPreferredSize(textFields);
        GridBagConstraints gbc_NInum = new GridBagConstraints();
        gbc_NInum.gridx = 3;
        gbc_NInum.gridy = 6;

        JLabel wageLabel = new JLabel("Wage/Salary: ");
        GridBagConstraints gbc_wageLabel = new GridBagConstraints();
        gbc_wageLabel.gridx = 1;
        gbc_wageLabel.gridy = 7;

        JTextField wage = new JTextField();
        wage.setFont(textFieldFont);
        wage.setPreferredSize(textFields);
        GridBagConstraints gbc_wage = new GridBagConstraints();
        gbc_wage.gridx = 1;
        gbc_wage.gridy = 8;

        addEmployeeWindow.add(addEmployeeWindowLabel, gbc_addEmployeeLabel);
        addEmployeeWindow.add(firstNameLabel, gbc_firstNameLabel);
        addEmployeeWindow.add(firstName, gbc_firstName);
        addEmployeeWindow.add(lastNameLabel,gbc_lastNameLabel);
        addEmployeeWindow.add(lastName, gbc_lastName);
        addEmployeeWindow.add(emailLabel, gbc_emailLabel);
        addEmployeeWindow.add(email, gbc_email);
        addEmployeeWindow.add(phoneNumLabel, gbc_phoneNumLabel);
        addEmployeeWindow.add(phoneNum, gbc_phoneNum);
        addEmployeeWindow.add(addressLabel, gbc_addressLabel);
        addEmployeeWindow.add(address, gbc_address);
        addEmployeeWindow.add(NInumLabel, gbc_NInumLabel);
        addEmployeeWindow.add(NInum, gbc_NInum);
        addEmployeeWindow.add(wageLabel, gbc_wageLabel);
        addEmployeeWindow.add(wage, gbc_wage);
        addEmployeeWindow.add(addEmployeeWindowButton, gbc_addEmployeeButton);

        addEmployeeWindowButton.addActionListener(e -> {
            if(validateInput(firstName, lastName, email, phoneNum, address, NInum, wage, myEmsUi)){
                employeesDB.addEmployee(user.getId(), firstName.getText(), lastName.getText(), email.getText(), phoneNum.getText(),
                        address.getText(), NInum.getText(), Float.parseFloat(wage.getText()));

                DefaultTableModel newTableModel = new DefaultTableModel(employeeInfo.getEmployeeInfo(user), employeeInfo.getColumnNames());
                table.setModel(newTableModel);
                addEmployeeWindow.dispose();

                JOptionPane.showMessageDialog(myEmsUi, "Employee added successfully!");
            }
        });

        addEmployeeButton.addActionListener(e -> {
            addEmployeeWindow.setTitle("Add a new employee");
            addEmployeeWindow.setLocationRelativeTo(employeesPanel);
            addEmployeeWindow.setVisible(true);
        });

        return scrollPane;
    }
}