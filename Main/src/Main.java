import Controller.LoginController;
import Controller.SignupController;
import Dao.LoginDAO;
import Dao.SignupDAO;
import View.Loginview;

public class Main {
    public static void main(String[] args) throws Exception {
        Loginview view = new Loginview();
        LoginDAO pdo = new LoginDAO();
        new LoginController(pdo, view);
        SignupDAO pdo2 = new SignupDAO();
        new SignupController(pdo2, view);
    }
}
