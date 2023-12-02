package Controller;

import Model.Person;
import Model.Signup;

import View.PersonView;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;

import java.awt.event.*;

import Dao.PersonDAO;
import Dao.SignupDAO;

public class PersonController  {
    // Attributs
    private PersonDAO personDAO;
    private SignupDAO signupDAO;
    private PersonView view;

    // Constructor
    public PersonController(PersonDAO pD, PersonView vi) {
        this.personDAO = pD;
        this.view = vi;
        this.signupDAO = new SignupDAO();


        view.getButtonAjouter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                int id = 0;
                String nom = view.getNomTextField().getText();
                String prenom = view.getPrenomTextField().getText();
                String age = view.getAgeTextField().getText();
                // Creation un objet Personne avec ces donnes
                Person personne = new Person(id, nom, prenom, age);
                // Appeler la methode d'ajouter personne
                personDAO.addPerson(personne);
                view.getButtonAfficher().doClick();
                view.clearTextFields();

            }
        });

        view.getButtonAfficher().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                List<Person> personnes = personDAO.showPersonnes();
                view.displayPersons(personnes);
                view.clearTextFields();
            }
        });

        view.getButtonExtract().addActionListener(e -> {
            List<Person> personnes = personDAO.ExtractPersonneData();
            List<Signup> logins = signupDAO.extractSignupData();
            File file = new File("MYDATABASE.txt");

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter writer = new PrintWriter(file);
                writer.println("Table Personne: ");
                for (Person person : personnes) {
                    writer.println("\tID: " + person.getid());
                    writer.println("\tName: " + person.getname());
                    writer.println("\tLastName: " + person.getprenom());
                    writer.println("\tAge: " + person.getage());
                    writer.println();  
                }
                writer.println("--------------------------------------");
                writer.println("Table Login: ");
                for (Signup login : logins) {
                    writer.println("\tUsername: " + login.getusername());
                    writer.println("\tEmail: " + login.getemail());
                    writer.println("\tPassword: " + login.getpassword());
                    writer.println();  
                }

                writer.flush();
                writer.close();
                System.out.println("Data extracted and saved to MYDATABASE.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.getTable().getSelectedRow() != -1) {
                    int id = (Integer) view.getTable().getValueAt(view.getTable().getSelectedRow(), 0);
                    view.getButtonSupprimer().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent args0) {
                            personDAO.delPerson(id);
                            view.getButtonAfficher().doClick();
                            view.clearTextFields();
                        }
                    });
                }
            }
        });

    }
}
