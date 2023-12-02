
package Dao.interfaces;

import java.util.List;

import Model.Signup;

public interface SignupDAOInterface {
    // Method to add a person
    public int SaveInfo(Signup info);

    public List<Signup> extractSignupData();

} 

