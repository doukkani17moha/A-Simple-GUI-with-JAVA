package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Person;

import java.awt.*;
import java.util.List;

public class PersonView extends JFrame {
    // Declarations globales des composants
    JButton Ajouter, Supprimer, Afficher, Extract;
    JPanel P1, P2, P3,Paneau;
    JTextField noField, prField, agField;
    JLabel nom, prenom, age;
    JTable Tab;
    DefaultTableModel te = new DefaultTableModel();

    // Constructor
    public PersonView() {
        setTitle("Exemple Global");
        setSize(700, 240);
        setLocationRelativeTo(null);
        // Instanciation des composants
        // Creation de tableau
        Tab = new JTable(te);
        // Insertion les noms de column
        te.addColumn("Id");
        te.addColumn("Nom");
        te.addColumn("Prenom");
        te.addColumn("Age");
        // Labels
        nom = new JLabel("nom");
        prenom = new JLabel("prenom");
        age = new JLabel("age");
        // TextFiels
        noField = new JTextField(6);
        prField = new JTextField(6);
        agField = new JTextField(6);
        // Buttons
        Ajouter = new JButton("Ajouter");
        Supprimer = new JButton("Supprimer");
        Afficher = new JButton("Afficher");
        Extract = new JButton("Extract Database");
        // Paneau
        P1 = new JPanel();
        P2 = new JPanel();
        P3 = new JPanel();
        Paneau = new JPanel();
        // Ordonancement (GridLayout & add)
        P1.setLayout(new GridLayout(2, 1));
        P3.setLayout(new GridLayout(3, 2));
        Paneau.setLayout(new BorderLayout());
        P3.add(nom);
        P3.add(noField);
        P3.add(prenom);
        P3.add(prField);
        P3.add(age);
        P3.add(agField);
        P1.add(P3);
        P2.add(Ajouter);
        P2.add(Supprimer);
        P2.add(Afficher);
        P2.add(Extract);
        P1.add(P2);
        Paneau.add(new JScrollPane(Tab), BorderLayout.CENTER);
        Paneau.add(P1, BorderLayout.NORTH);
        add(Paneau);
        setVisible(true);
    }

    // function to cleartext
    public void clearTextFields() {
        noField.setText("");
        prField.setText("");
        agField.setText("");
    }

    // Getters Of Buttons
    public JButton getButtonAjouter() {
        return Ajouter;
    }

    public JButton getButtonAfficher() {
        return Afficher;
    }

    public JButton getButtonSupprimer() {
        return Supprimer;
    }
    public JButton getButtonExtract() {
        return Extract;
    }
    public JTable getTable() {
        return Tab;
    }

    public JTextField getNomTextField() {
        return noField;
    }

    public JTextField getPrenomTextField() {
        return prField;
    }

    public JTextField getAgeTextField() {
        return agField;
    }
    public void displayPersons( List<Person> persons) {
        te.setRowCount(0); // Clear existing rows

        for (Person person : persons) {
            // Assuming Person class has getters for nom, prenom, and age
            String nom = person.getname();
            String prenom = person.getprenom();
            String age = person.getage();
            int id = person.getid();

            Object[] rowData = {id, nom, prenom, age};
            te.addRow(rowData);
        }
}

}
