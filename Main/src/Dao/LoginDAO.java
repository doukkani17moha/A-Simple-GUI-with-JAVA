package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.interfaces.LoginDAOInterface;
import Model.Login;

public class LoginDAO implements LoginDAOInterface {
    private Connection connection = null;
    private PreparedStatement s1 = null;
    ResultSet resultSet = null;

    public LoginDAO() {
        // Create a single DBConnection instance to be reused
        DBConnection connec = new DBConnection();
        connection = connec.getConnection();
    }

    
    // Methode de verification les infos
    public int verifyinfo(Login info) {
        try {
            String query = "SELECT username, password FROM admin WHERE username = ? AND password = ?";
            s1 = connection.prepareStatement(query);
            s1.setString(1, info.getusername());
            s1.setString(2, info.getpassword());
            resultSet = s1.executeQuery();
            if (resultSet.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeResources();
        }
    }


    private void closeResources() {
        try {
            if (s1 != null) {
                s1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
