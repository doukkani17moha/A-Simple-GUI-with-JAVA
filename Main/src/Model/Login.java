package Model;

public class Login {
     //Attributs
     public String username, password;
     //Constructor
     public Login(String u, String p){
         this.username = u;
         this.password = p;
     }
     //Getters
     public String getusername(){
         return username;
     }
     @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + "]";
    }
    public String getpassword(){
         return password;
     }

     //Setters
     public void setname(String no){
         this.username = no;
     }
     public void setpassword(String pr){
         this.password = pr;
     }
}
