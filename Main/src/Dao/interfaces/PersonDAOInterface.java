package Dao.interfaces;

import Model.Person;
import java.util.*;

/**
 * PersonDAOInterface
 */
public interface PersonDAOInterface {
    // Method to add a person
    public void addPerson(Person person);

    // Method to delete a person
    public void delPerson(int id);

    // Method to retrieve a list of persons
    public List<Person> showPersonnes();
    // Method to retrieve a list of persons
    public List<Person> ExtractPersonneData();


}

