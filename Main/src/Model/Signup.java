package Model;

public class Signup {
     //Attributs
     public String email, username, password, confirmpassword;
     //Constructor
     public Signup(String e, String u, String p){
         this.email = e;
         this.username = u;
         this.password = p;
     }
     //Getters
     public String getusername(){
         return username;
     }
     public String getpassword(){
         return password;
     }
     public String getemail(){
         return email;
     }
     @Override
    public String toString() {
        return "Info [Email=" + email + ", username=" + username + ", password=" + password + "]";
    }

     //Setters
     public void setname(String no){
         this.username = no;
     }
     public void setpassword(String pr){
         this.password = pr;
     }

     public void setemail(String em){
         this.email = em;
     }
}
