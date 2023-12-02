package Controller;

import java.awt.event.*;

import javax.swing.*;

import Dao.LoginDAO;
import Dao.PersonDAO;
import View.Loginview;
import View.PersonView;
import Model.Login;

public class LoginController {
    // Attributs
    private LoginDAO loginDAO;
    private Loginview view;


    // Constructor
    public LoginController(LoginDAO loginDAO, Loginview view) {
        this.loginDAO = loginDAO;
        this.view = view;


        view.getButtonLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                String username = view.getUsernameLoginTextField().getText();
                String password = view.getPasswordLoginTextField().getText();
                Login login = new Login(username, password);
                if (loginDAO.verifyinfo(login) == 1) {
                    JOptionPane.showMessageDialog(view, "You are successfully logged in.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    view.dispose();
                    PersonView view = new PersonView();
                    PersonDAO pdo = new PersonDAO();
                    new PersonController(pdo, view);
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid username or password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                view.clearTextFields();
            }
        });


    }

}
