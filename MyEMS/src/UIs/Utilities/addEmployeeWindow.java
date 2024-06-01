package UIs.Utilities;
import DB_Usage.User;
import DB_Usage.employeeAdded;
import UIs.myEmsUI;
import javax.swing.*;
import java.awt.*;

public class addEmployeeWindow extends JDialog {

    private User user;
    private static myEmsUI myEmsUI;

    public addEmployeeWindow(User user, myEmsUI myEmsUI){

        setFocusable(true);
        setSize(1300, 750);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.gray);

        Dimension textFields = new Dimension(300, 40);
        Font textFieldFont = new Font(("Dialog"), Font.PLAIN, 20);

        GridBagLayout windowGrid = new GridBagLayout();
        windowGrid.columnWidths = new int[]{50, 500, 150, 500, 50};
        windowGrid.rowHeights = new int[]{30, 50, 100, 50, 100, 50, 100, 50, 100, 30};
        setLayout(windowGrid);

        JLabel addEmployeeLabel = new JLabel("Add Employee");
        GridBagConstraints gbc_addEmployeeLabel = new GridBagConstraints();
        gbc_addEmployeeLabel.gridx = 2;
        gbc_addEmployeeLabel.gridy = 0;

        JButton addEmployeeButton = new JButton("Add");
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

        add(addEmployeeLabel, gbc_addEmployeeLabel);
        add(firstNameLabel, gbc_firstNameLabel);
        add(firstName, gbc_firstName);
        add(lastNameLabel,gbc_lastNameLabel);
        add(lastName, gbc_lastName);
        add(emailLabel, gbc_emailLabel);
        add(email, gbc_email);
        add(phoneNumLabel, gbc_phoneNumLabel);
        add(phoneNum, gbc_phoneNum);
        add(addressLabel, gbc_addressLabel);
        add(address, gbc_address);
        add(NInumLabel, gbc_NInumLabel);
        add(NInum, gbc_NInum);
        add(wageLabel, gbc_wageLabel);
        add(wage, gbc_wage);
        add(addEmployeeButton, gbc_addEmployeeButton);

        addEmployeeButton.addActionListener(e -> {
            validateInput(firstName, lastName, email, phoneNum, address, NInum, wage, myEmsUI);

        });

    }

    public static boolean validateInput(JTextField fname, JTextField lname, JTextField email, JTextField phoneNum,
                                        JTextField address, JTextField NInum, JTextField wage, myEmsUI myEmsUI){

        String firstName = fname.getText();
        String lastName = lname.getText();
        String emailAdd = email.getText();
        String phoneNumber = phoneNum.getText();
        String homeAddress = address.getText();
        String NiNum = NInum.getText();
        String wages = wage.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || wage.getText().isEmpty() || NiNum.isEmpty() ||
                homeAddress.isEmpty() || wages.isEmpty() || (emailAdd.isEmpty() && phoneNumber.isEmpty())){
            JOptionPane.showMessageDialog(myEmsUI, "Please fill all necessary fields in appropriate formats.");
            return false;
        }

        if (!wages.matches("[-+]?[0-9]*\\.?[0-9]+")){
            JOptionPane.showMessageDialog(myEmsUI, "Please ensure that the wage is numerical.");
            return false;
        }

        return true;
    }
}