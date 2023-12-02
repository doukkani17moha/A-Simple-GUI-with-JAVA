package Model;

import java.io.*;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    //Attributs
    public String nom, prenom, age;
    public int id;
    //Constructor
    public Person(int id,String n, String p, String a){
        this.id = id;
        this.nom = n;
        this.prenom = p;
        this.age = a;
    }
    //Getters
    public String getname(){
        return nom;
    }
    public String getprenom(){
        return prenom;
    }
    public String getage(){
        return age;
    }
    public int getid(){
        return id;
    }
    //Setters
    public void setname(String no){
        this.nom = no;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
    }
    public void setprenom(String pr){
        this.prenom = pr;
    }
    public void setage(String ag){
        this.age = ag;
    }
    public void setid(int idd){
        this.id = idd;
    }
    
}
