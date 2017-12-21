import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView implements ItemListener
{
    JPanel cards;
    final static String USER = "User";
    final static String ADMIN = "Admin";
    final static int extraWindowWidth = 100;
    
    public static void main(String[] args)
    {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch(UnsupportedLookAndFeelException ex){
            ex.printStackTrace();
        }catch(IllegalAccessException ex){
            ex.printStackTrace();
        }catch(InstantiationException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal",Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
    public static void createAndShowGUI(){
        JFrame frame = new JFrame("SignIn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainView view = new MainView();
        view.addUAtoPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    public void addUAtoPane(Container pane){
        JPanel view = new JPanel();
        String Items[] = { USER, ADMIN };
        JComboBox<String> cb = new JComboBox<>(Items);
        cb.setEditable(false);
        cb.addItemListener(this);
        view.add(cb);
        
        cards = new JPanel(new CardLayout());
        cards.add(new UserPanel().getUserPanel(),USER);
        cards.add(new AdminPanel().getAdminPanel(),ADMIN);
        
        pane.add(view, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards,(String)evt.getItem());
    }
}
class UserPanel extends JFrame implements ActionListener
{
    JButton SignInButton,SignUpButton;
    JTextField UserNameField;
    JPasswordField PasswordField;
    JPanel MainPanel;
    
    public JPanel getUserPanel()
    {
        JLabel UserNameLabel = new JLabel("UserName: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel FirstTimeUserLabel = new JLabel("First time user? Click Sign Up to register!");
        
        SignInButton = new JButton("Sign In");
        SignUpButton = new JButton("Sign Up");
        
        UserNameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        
        JPanel UserNamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel FirstTimeUserPanel =new JPanel();
        MainPanel = new JPanel();
        
        UserNamePanel.add(UserNameLabel);
        UserNamePanel.add(UserNameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        FirstTimeUserPanel.add(FirstTimeUserLabel);
        
        MainPanel.add(FirstTimeUserPanel);
        MainPanel.add(SignUpButton);
        MainPanel.add(UserNamePanel);
        MainPanel.add(PasswordPanel);
        MainPanel.add(SignInButton);
        
        SignUpButton.addActionListener(this);
        SignInButton.addActionListener(this);
        
        
        return MainPanel;
    }
    public void actionPerformed(ActionEvent evt)
    {
        String arg = evt.getActionCommand();
        
        if(arg.equals("Sign Up")){
            UserSignUpControl signup = new UserSignUpControl();
        }
        if(arg.equals("Sign In")){
            String UserName = UserNameField.getText();
            char[] Password = PasswordField.getPassword();
            UserSigninControl signin = new UserSigninControl(UserName,Password);
        }
    }

}
class AdminPanel extends JFrame implements ActionListener
{
    JButton SignInButton;
    JTextField AdminNameField;
    JPasswordField PasswordField;
    JPanel MainPanel;
    
    public JPanel getAdminPanel()
    {
        JLabel AdminNameLabel = new JLabel("AdminName: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        
        SignInButton = new JButton("Sign In");
        
        AdminNameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        
        JPanel AdminNamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        MainPanel = new JPanel();
        
        AdminNamePanel.add(AdminNameLabel);
        AdminNamePanel.add(AdminNameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        
        MainPanel.add(AdminNamePanel);
        MainPanel.add(PasswordPanel);
        MainPanel.add(SignInButton);
        
        SignInButton.addActionListener(this);
        
        return MainPanel;
    }
    public void actionPerformed(ActionEvent evt)
    {
        String arg = evt.getActionCommand();
        
        if(arg.equals("Sign In")){
            String AdminName = AdminNameField.getText();
            char[] Password = PasswordField.getPassword();
            AdminSigninControl signin = new AdminSigninControl(AdminName,Password);
        }
    }
}
