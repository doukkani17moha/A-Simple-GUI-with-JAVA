package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.interfaces.PersonDAOInterface;
import Model.Person;

public class PersonDAO implements PersonDAOInterface  {
    private Connection connection = null;
    private PreparedStatement s1 = null;

    public PersonDAO() {
        // Create a single DBConnection instance to be reused
        DBConnection connec = new DBConnection();
        connection = connec.getConnection();
    }

 

    // Methode d'ajout
    public void addPerson(Person personne) {
        try {
            String query = "INSERT INTO persons (nom, prenom, age) VALUES (?, ?, ?)";
            s1 = connection.prepareStatement(query);
            s1.setString(1, personne.getname());
            s1.setString(2, personne.getprenom());
            s1.setString(3, personne.getage());
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Methode Supprimer
    public void delPerson(int id) {
        try {
            String query = "DELETE FROM persons WHERE id = ?";
            s1 = connection.prepareStatement(query);
            s1.setInt(1, id);
            s1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Methode ExtractData
    public List<Person> ExtractPersonneData() {
        List<Person> personList = new ArrayList<>();

        try {
            String query = "SELECT * FROM persons";
            s1 = connection.prepareStatement(query);
            ResultSet res = s1.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String age = res.getString("age");
                Person personne = new Person(id, nom, prenom, age);
                personList.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return personList;
    }

    

    // Methode pour Affichage
    public List<Person> showPersonnes() {
        List<Person> personList = new ArrayList<>();

        try {
            String query = "SELECT * FROM persons";
            s1 = connection.prepareStatement(query);
            ResultSet res = s1.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String age = res.getString("age");
                Person personne = new Person(id, nom, prenom, age);
                personList.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return personList;
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
