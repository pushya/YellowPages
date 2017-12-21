import java.lang.*;
import javax.swing.*;

public class UserSigninControl{

    private Account Acct;
    public UserSigninControl(String UName, char[] Pswd){
        Acct = new Account(UName, Pswd);
        if(Acct.userSignin()){
            System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            new MenuView(UName,"user");
        }else{
            System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
