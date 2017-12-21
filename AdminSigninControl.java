import java.lang.*;
import javax.swing.*;

public class AdminSigninControl{

    private Administration Acct;
    public AdminSigninControl(String AName, char[] Pswd){
        Acct = new Administration(AName, Pswd);
        if(Acct.adminSignin()){
            System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            new MenuView(AName,"admin");
        }else{
            System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid admin name or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
