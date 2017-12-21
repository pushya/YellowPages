import java.lang.*;
import java.sql.*;

public class Account extends DataObject
{
    private String Username,Name,PhoneNo,Address;
    private char[] Password,RePassword;
    
    public Account(String UN,char[] Pswd,char[] RePswd,String N,String PhoneNo,String Address,String Message){
        Username = UN;
        Password = Pswd;
        RePassword = RePswd;
        Name = N;
        PhoneNo = this.PhoneNo;
        Address = this.Address;
        setMessage(Message);
    }
    public Account(String UN,char[] Pswd){
        Username = UN;
        Password = Pswd;
    }
    
    public boolean signUp(){
        boolean flag = !Username.equals("")&&!Password.equals("")&&!RePassword.equals("")&&Password.equals(RePassword);
        try{
            if(flag){
                DBConnection DB = new DBConnection();
                Connection DBConn = DB.openConnection();
                Statement stmt = DBConn.createStatement();
                System.out.println(DBConn);
                String SQL_Command = "SELECT Username FROM Account WHERE Username = '"+Username+"'";
                ResultSet Rset = stmt.executeQuery(SQL_Command);
                flag = flag && !Rset.next();
                if(flag){
                    SQL_Command = "INSERT INTO Account(Username,Password,Name,PhoneNo,Address,Message) VALUES('"+Username+"','"+Password+"','"+Name+"','"+PhoneNo+"','"+Address+"','"+getMessage()+"')";
                    stmt.executeUpdate(SQL_Command);
                }
                stmt.close();
                DB.closeConnection();
            }
        }
        catch(java.sql.SQLException e){
            flag = false;
            System.out.println("SQLException: "+ e);
            while(e!=null){
                System.out.println("SQLState: "+ e.getSQLState());
                System.out.println("Message: "+e.getMessage());
                System.out.println("Vendor: "+e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }
        catch(java.lang.Exception e)
        {
            flag = false;
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
        return flag;
    }
    public boolean userSignin(){
        boolean flag = true;
        try{
            if(flag){
                DBConnection DB = new DBConnection();
                Connection DBConn = DB.openConnection();
                Statement stmt = DBConn.createStatement();
                System.out.println(DBConn);
                String SQL_Command = "SELECT Name FROM Account WHERE Username = '"+Username+"' AND Password = '"+Password+"'";
                ResultSet Rset = stmt.executeQuery(SQL_Command);
                if(Rset.next())
                    flag = true;
                else
                    flag = false;
                stmt.close();
                DB.closeConnection();
            }
        }
        catch(java.sql.SQLException e){
            flag = false;
            System.out.println("SQLException: "+ e);
            while(e!=null){
                System.out.println("SQLState: "+ e.getSQLState());
                System.out.println("Message: "+e.getMessage());
                System.out.println("Vendor: "+e.getErrorCode());
                e = e.getNextException();
                System.out.println("");
            }
        }catch(java.lang.Exception e){
            flag = false;
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
        return flag;
    }
}
