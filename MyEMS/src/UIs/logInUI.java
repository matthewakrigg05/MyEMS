package UIs;
import DB_Usage.User;
import DB_Usage.emsDB;
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

        GridBagConstraints emailLabelConsts = new GridBagConstraints();
        emailLabelConsts.gridx = 0;
        emailLabelConsts.gridy = 0;

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setSize(super.getWidth() - 30, 24);
        emailLabel.setFont(new Font("Dialog", Font.PLAIN, 20));

        GridBagConstraints emailFieldConsts = new GridBagConstraints();
        emailFieldConsts.gridx = 0;
        emailFieldConsts.gridy = 1;
        emailFieldConsts.insets = new Insets(10, 0, 25, 0);

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
        passwordFieldConsts.insets = new Insets(10, 0, 0, 0);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(getWidth() - 540, 40));
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));

        GridBagConstraints logInButtonConsts = new GridBagConstraints();
        logInButtonConsts.gridx = 0;
        logInButtonConsts.gridy = 4;
        logInButtonConsts.insets = new Insets(90, 0, 15, 0);

        final JButton logInButton = getLogInButton(emailField, passwordField);

        GridBagConstraints registerButtonConsts = new GridBagConstraints();
        registerButtonConsts.gridx = 0;
        registerButtonConsts.gridy = 5;

        final JLabel registerLabel = getRegisterLabel();

        logInPanel.add(emailLabel, emailLabelConsts);
        logInPanel.add(emailField, emailFieldConsts);
        logInPanel.add(passwordLabel, passwordLabelConsts);
        logInPanel.add(passwordField, passwordFieldConsts);
        logInPanel.add(logInButton, logInButtonConsts);
        logInPanel.add(registerLabel, registerButtonConsts);

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
            User user = emsDB.validateLogin(email, password);

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
