package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Loginview extends JFrame {
    // Attributes
    JPanel mainPanel, labelPanel, inputPanel, buttonPanel;
    JLabel usernameLabel, emaiLabel, passwordLabel, confirmPasswordLabel;
    JTextField usernameLoginField, usernameField, emailField;
    JPasswordField passwordLoginField, passwordField, confirmPasswordField;
    JButton loginButton, signupButton, switchToLoginButton, switchToSignupButton;
    CardLayout cardLayout;

    // Constructor
    public Loginview() {
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Login View
         createLoginView();

        // Signup View
         createSignupView();

        add(mainPanel);
        setVisible(true);
    }

    public void createLoginView() {
        labelPanel = new JPanel(new GridLayout(2, 1));
        inputPanel = new JPanel(new GridLayout(2, 1));
        usernameLabel = new JLabel("Username:");
        usernameLoginField = new JTextField(6);
        passwordLabel = new JLabel("Password:");
        passwordLoginField = new JPasswordField(6);
        loginButton = new JButton("Login");

        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);
        inputPanel.add(usernameLoginField);
        inputPanel.add(passwordLoginField);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        switchToSignupButton = new JButton("Switch to Signup");

        buttonPanel.add(loginButton);
        buttonPanel.add(switchToSignupButton);

        JPanel loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(labelPanel, BorderLayout.WEST);
        loginPanel.add(inputPanel, BorderLayout.CENTER);
        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        switchToSignupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(mainPanel);
            }
        });

        mainPanel.add(loginPanel, "login");
    }



    public void clearTextFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    private void createSignupView() {
        labelPanel = new JPanel(new GridLayout(4, 1));
        inputPanel = new JPanel(new GridLayout(4, 1));
        emaiLabel = new JLabel("Email:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        emailField = new JTextField(6);
        usernameField = new JTextField(6);
        passwordField = new JPasswordField(6);
        confirmPasswordField = new JPasswordField(6);
        signupButton = new JButton("Signup");

        labelPanel.add(emaiLabel);
        labelPanel.add(usernameLabel);
        labelPanel.add(passwordLabel);
        labelPanel.add(confirmPasswordLabel);

        inputPanel.add(emailField);
        inputPanel.add(usernameField);
        inputPanel.add(passwordField);
        inputPanel.add(confirmPasswordField);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        switchToLoginButton = new JButton("Switch to Login"); 
        buttonPanel.add(signupButton);
        buttonPanel.add(switchToLoginButton);

        JPanel signupPanel = new JPanel(new BorderLayout());
        signupPanel.add(labelPanel, BorderLayout.WEST);
        signupPanel.add(inputPanel, BorderLayout.CENTER);
        signupPanel.add(buttonPanel, BorderLayout.SOUTH);

        switchToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(mainPanel);
            }
        });

        mainPanel.add(signupPanel, "signup");
    }

       // Getters Of Buttons
    public JButton getButtonLogin() {
        return loginButton;
    }

    public JButton getButtonSignup() {
        return signupButton;
    }

    public JTextField getUsernameTextField() {
        return usernameField;
    }
    public JTextField getUsernameLoginTextField() {
        return usernameLoginField;
    }

    public JTextField getPasswordLoginTextField() {
        return passwordLoginField;
    }

    public JTextField getPasswordTextField() {
        return passwordField;
    }

    public JTextField getConfirmPasswordTextField() {
        return confirmPasswordField;
    }

    public JTextField getEmailTextField() {
        return emailField;
    }

}
