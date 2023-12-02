
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.interfaces.SignupDAOInterface;
import Model.Signup;

public class SignupDAO implements SignupDAOInterface {
    private Connection connection = null;
    private PreparedStatement s1 = null;
    ResultSet resultSet = null;

    public SignupDAO() {
        // Create a single DBConnection instance to be reused
        DBConnection connec = new DBConnection();
        connection = connec.getConnection();
    }

    // Method to save information (email, username, password)
    public int SaveInfo(Signup info) {
        try {
            String checkQuery = "SELECT username, email FROM admin WHERE username = ? OR email = ?";
            s1 = connection.prepareStatement(checkQuery);
            s1.setString(1, info.getusername());
            s1.setString(2, info.getemail());
            resultSet = s1.executeQuery();
            if (resultSet.next()) {
                // Username or email already exists, return 2 
                return 2;
            } else {
                String insertQuery = "INSERT INTO admin (email, username, password) VALUES (?, ?, ?)";
                s1 = connection.prepareStatement(insertQuery);
                s1.setString(1, info.getemail());
                s1.setString(2, info.getusername());
                s1.setString(3, info.getpassword());

                int rowsAffected = s1.executeUpdate();

                if (rowsAffected > 0) {
                    return 1;
                } else {
                    return 0;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeResources();
        }
    }

          // Methode ExtractData
    public List<Signup> extractSignupData() {
        List<Signup> SignupList = new ArrayList<>();

        try {
            String query = "SELECT * FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Signup login = new Signup(email, username, password);
                SignupList.add(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return SignupList;
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
