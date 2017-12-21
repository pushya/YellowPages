import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuView extends JFrame implements ActionListener
{
    String UserName,AdminName;
    JTextField othernameField
    public MenuView(String Name,String type){
        if(type.equals("admin")){
            AdminName = Name;
            adminMenu();
        }
        else{
            UserName = Name;
            userMenu();
        }
    }
    void userMenu(){
        JPanel Search = JPanel();
        
        JLabel welcomeLabel = new JLabel("Welcome "+UserName+"!");
        JLabel introLabel = new JLabel("Find out the Phone number by entering the username or name  of the person/company ");
        JLabel othernameLabel = new JLabel("Their User name or name: ");
        
        JButton searchButton = new JButton("Search: ");
        
        othernameField = new JTextField(15);
        
        Search.add(welcomeLabel);
        Search.add(introLabel);
        Search.add(othernameLabel);
        Search.add(othernameField);
        Search.add(searchButton);
    }
    void adminMenu(){
        JLabel othernameLabel = new JLabel("Their User name or name: ");
        
        JButton searchButton = new JButton("Admin Search: ");
        
        othernameField = new JTextField(15);
        
        JPanel Search = new JPanel();
        Search.add(othernameLabel);
        Search.add(othernameField);
        Search.add(searchButton);
        searchButton.addActionListener(this);
        addWindowListener(new WindowAdapter() // handle window closing event
                          {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    void actionPerformed(ActionEvent evt){
        String arg = evt.getActionCommand();
        if(arg.equals("Search")){
            UserSearchControl search = new UserSearchControl(othernameField.getText());
        }
        else
        {
            AdminSearchControl search = new AdminSearchControl(othernameField.getText());
        }
    }
}
