package UIs;
import DB_Init.emsDB;
import DB_Init.validRegistration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class registerUI extends mainFrame implements ActionListener {

    public registerUI() throws IOException {
        super("MyEMS Registration");
    }

    @Override
    protected void addUIcomponents() {

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());

        GridBagConstraints emailLabelConsts = new GridBagConstraints();
        emailLabelConsts.gridx = 0;
        emailLabelConsts.gridy = 0;

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setSize(super.getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints emailFieldConsts = new GridBagConstraints();
        emailFieldConsts.gridx = 0;
        emailFieldConsts.gridy = 1;
        emailFieldConsts.insets = new Insets(10, 0, 50, 0);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        emailField.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints passwordLabelConsts = new GridBagConstraints();
        passwordLabelConsts.gridx = 0;
        passwordLabelConsts.gridy = 2;

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setSize(getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints passwordFieldConsts = new GridBagConstraints();
        passwordFieldConsts.gridx = 0;
        passwordFieldConsts.gridy = 3;
        passwordFieldConsts.insets = new Insets(10, 0, 25, 0);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));

        GridBagConstraints reTypeLabelConsts = new GridBagConstraints();
        reTypeLabelConsts.gridx = 0;
        reTypeLabelConsts.gridy = 4;

        JLabel reTypeLabel = new JLabel("Re-Type Password: ");
        reTypeLabel.setSize(getWidth() - 50, 24);
        reTypeLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints reTypePasswordConsts = new GridBagConstraints();
        reTypePasswordConsts.gridx = 0;
        reTypePasswordConsts.gridy = 5;
        reTypePasswordConsts.insets = new Insets(10, 0, 0, 0);

        JPasswordField reTypeField = new JPasswordField();
        reTypeField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        reTypeField.setFont(new Font("Dialog", Font.PLAIN, 28));

        GridBagConstraints registerButtonConsts = new GridBagConstraints();
        registerButtonConsts.gridx = 0;
        registerButtonConsts.gridy = 6;
        registerButtonConsts.insets = new Insets(90, 0, 15, 0);

        JButton registerButton = getRegisterButton(emailField, passwordField, reTypeField);

        GridBagConstraints logInButtonConsts = new GridBagConstraints();
        logInButtonConsts.gridx = 0;
        logInButtonConsts.gridy = 7;
        JLabel logInLabel = new JLabel("<html><a href=\"#\">Already have an account? Sign in Here.</a></html>");
        logInLabel.setFont(new Font("Dialog", Font.PLAIN, 16));

        logInLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                registerUI.this.dispose();

                // launch the register gui
                try {
                    new logInUI().setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        registerPanel.add(emailLabel, emailLabelConsts);
        registerPanel.add(emailField, emailFieldConsts);
        registerPanel.add(passwordLabel, passwordLabelConsts);
        registerPanel.add(passwordField, passwordFieldConsts);
        registerPanel.add(reTypeLabel, reTypeLabelConsts);
        registerPanel.add(reTypeField, reTypePasswordConsts);
        registerPanel.add(registerButton, registerButtonConsts);
        registerPanel.add(logInLabel, logInButtonConsts);
        add(registerPanel);
    }

    private JButton getRegisterButton(JTextField emailField, JPasswordField passwordField, JPasswordField reTypeField) {
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(90, 30));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String rePassword = String.valueOf(reTypeField.getPassword());

                // First checks that the email is possible, sections are filled, and that the passwords match.
                if(validRegistration.validateRegistrationInput(email, password, rePassword)){

                    // THEN, checks if email exists already in DB, if not, adds to DB
                    if(emsDB.register(email, password)) {
                        registerUI.this.dispose();

                        logInUI logInUI;
                        try {
                            logInUI = new logInUI();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        logInUI.setVisible(true);

                        JOptionPane.showMessageDialog(logInUI, "Account registered successfully!");
                    }
                    else{
                        // Only outcome if email is in DB
                        JOptionPane.showMessageDialog(registerUI.this, "This email is already in use...");
                    }
                }

                else{
                    // If the email is invalid
                    if(!validRegistration.validEmailAddress(email)){
                        JOptionPane.showMessageDialog(registerUI.this, "Please use a valid email address.");
                    }
                    // If password is invalid
                    else if (!validRegistration.validPassword(password)){
                        JOptionPane.showMessageDialog(registerUI.this, "Please use a valid password");
                    }
                    else {
                        JOptionPane.showMessageDialog(registerUI.this, "Registration failed... \n " +
                            "Check that your passwords match.");
                    }
                }
            }
        });
        return registerButton;
    }
}
