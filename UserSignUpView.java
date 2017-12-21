import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserSignUpView extends JFrame{
    private SignUpPanel SU_Panel;
    public UserSignUpView(){
        
        addWindowListener (new WindowAdapter()  //handle window event
                           {
            public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
        });
        
        Container contentPane = getContentPane();
        SU_Panel = new SignUpPanel();
        contentPane.add(SU_Panel);
        show();
    }
}
class SignUpPanel extends JFrame implements ActionListener
{
    private JButton RegisterButton;
    private JTextField UsernameField,NameField,PhoneNoField,AddressField,MessageField;
    private JPasswordField PasswordField,RePasswordField;
    private String UName,Pswd,RePswd,Name;
    private Account Acct;
    
    public SignUpPanel(){
        RegisterButton = new JButton("Register");
        
        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        RePasswordField = new JPasswordField(15);
        NameField = new JTextField(15);
        PhoneNoField = new JTextField(10);
        AddressField = new JTextField(30);
        MessageField = new JTextField(100);
        
        JLabel UsernameLabel = new JLabel("UserName: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel RePasswordLabel = new JLabel("Re-enter Password: ");
        JLabel NameLabel = new JLabel("Name");
        JLabel PhoneNoLabel = new JLabel("Phone Number: ");
        JLabel AddressLabel = new JLabel("Address: ");
        JLabel MessageLabel = new JLabel("Write about yourself or your Company");
        
        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel RePasswordPanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel PhoneNoPanel =new JPanel();
        JPanel AddressPanel = new JPanel();
        JPanel MessagePanel = new JPanel();
        JPanel DetailsPanel =new JPanel();
        
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        RePasswordPanel.add(RePasswordLabel);
        RePasswordPanel.add(RePasswordField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        PhoneNoPanel.add(PhoneNoLabel);
        PhoneNoPanel.add(PhoneNoField);
        AddressPanel.add(AddressLabel);
        AddressPanel.add(AddressField);
        MessagePanel.add(MessageLabel);
        MessagePanel.add(MessageField);
        
        add(UsernamePanel);
        add(PasswordPanel);
        add(RePasswordPanel);
        add(NamePanel);
        add(PhoneNoPanel);
        add(AddressPanel);
        add(MessagePanel);
        add(RegisterButton);
        
        setTitle("Sign Up");
        setSize(340, 210);
        
        //get screen size and set the location of the frame
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setLocation( screenWidth / 3, screenHeight / 4);
        
        addWindowListener (new WindowAdapter()  //handle window event
                           {
            public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
        });    }
    
    public void actionPerformed(ActionEvent evt)
    {
        String arg = evt.getActionCommand();
        if (arg.equals("Register")){
            String UName = UsernameField.getText();
            char[] Pswd = PasswordField.getPassword();
            char[] RePswd = RePasswordField.getPassword();
            String Name = NameField.getText();
            String PhoneNo = PhoneNoField.getText();
            String Address = AddressField.getText();
            String Message = MessageField.getText();
            
            Acct = new Account(UName, Pswd, RePswd, Name,PhoneNo,Address,Message);
            if (Acct.signUp())
                JOptionPane.showMessageDialog(null, "Account has been created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
