package UIs;
import DB_Usage.User;
import DB_Usage.userInit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

// File responsible for displaying login UI

public class logInUI extends mainFrame implements ActionListener {

    public logInUI() throws IOException {
        super("My EMS | Log In");
    }

    @Override
    protected void addUIcomponents() {
        JPanel logInPanel = new JPanel();
        logInPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc_emailLabel = new GridBagConstraints();
        gbc_emailLabel.gridx = 0;
        gbc_emailLabel.gridy = 0;

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setSize(super.getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.gridx = 0;
        gbc_emailField.gridy = 1;
        gbc_emailField.insets = new Insets(10, 0, 25, 0);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        emailField.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
        gbc_passwordLabel.gridx = 0;
        gbc_passwordLabel.gridy = 2;

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setSize(getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.gridx = 0;
        gbc_passwordField.gridy = 3;
        gbc_passwordField.insets = new Insets(10, 0, 0, 0);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));

        GridBagConstraints gbc_logInButton = new GridBagConstraints();
        gbc_logInButton.gridx = 0;
        gbc_logInButton.gridy = 4;
        gbc_logInButton.insets = new Insets(90, 0, 15, 0);

        final JButton logInButton = getLogInButton(emailField, passwordField);

        GridBagConstraints gbc_registerButton = new GridBagConstraints();
        gbc_registerButton.gridx = 0;
        gbc_registerButton.gridy = 5;

        final JLabel registerLabel = getRegisterLabel();

        logInPanel.add(emailLabel, gbc_emailLabel);
        logInPanel.add(emailField, gbc_emailField);
        logInPanel.add(passwordLabel, gbc_passwordLabel);
        logInPanel.add(passwordField, gbc_passwordField);
        logInPanel.add(logInButton, gbc_logInButton);
        logInPanel.add(registerLabel, gbc_registerButton);

        add(logInPanel);
    }

    private JLabel getRegisterLabel() {
        JLabel registerLabel
                = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>");
        registerLabel.setFont(new Font("Dialog", Font.PLAIN, 16));

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this gui
                logInUI.this.dispose();

                // launch the register gui
                try {
                    new registerUI().setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return registerLabel;
    }

    private JButton getLogInButton(JTextField emailField, JPasswordField passwordField) {
        JButton logInButton = new JButton("Log In");
        logInButton.setPreferredSize(new Dimension(70, 30));
        logInButton.addActionListener(e -> {

            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            User user = userInit.validateLogin(email, password);

            if (user != null) {
                logInUI.this.dispose();

                myEmsUI myEMS;
                try {
                     myEMS = new myEmsUI(user);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                myEMS.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(logInUI.this, "Login Failed");
            }
        });
        return logInButton;
    }
}
