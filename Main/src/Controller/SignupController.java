package Controller;

import java.awt.event.*;

import javax.swing.*;

import Dao.PersonDAO;
import Dao.SignupDAO;
import View.Loginview;
import View.PersonView;
import Model.Signup;

public class SignupController {
    // Attributs
    private SignupDAO SignupDAO;
    private Loginview view;
    
    // Constructor
    public SignupController(SignupDAO SignupDAO, Loginview view) {
        this.SignupDAO = SignupDAO;
        this.view = view;

        view.getButtonSignup().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                String email = view.getEmailTextField().getText();
                String username = view.getUsernameTextField().getText();
                String password = view.getPasswordTextField().getText();
                String confirmPassword = view.getConfirmPasswordTextField().getText();
        
                // Check if password and confirm password match
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(view, "Password and Confirm Password do not match.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Stop execution if passwords don't match
                }
        
                Signup signup = new Signup(email, username, password);
        
                int result = SignupDAO.SaveInfo(signup);
        
                if (result == 2) {
                    JOptionPane.showMessageDialog(view, "Username or Email already exists.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (result == 1) {
                    JOptionPane.showMessageDialog(view, "The info was saved correctly, Relogin", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    view.dispose();
                    PersonView view = new PersonView();
                    PersonDAO pdo = new PersonDAO();
                    new PersonController(pdo, view);

                }
        
                view.clearTextFields();
            }
        });
        
    }

}

