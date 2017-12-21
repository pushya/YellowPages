import java.lang.*;
import java.sql.*;

public class Administration
{
    private String AdminName;
    char[] Password;
    public Administration(String AN,char[] Pswd){
        AdminName = AN;
        Password = Pswd;
    }
    public boolean adminSignin(){
        boolean flag = true;
        try{
            if(flag){
                DBConnection DB = new DBConnection();
                Connection DBConn = DB.openConnection();
                Statement stmt = DBConn.createStatement();
                System.out.println(DBConn);
                String SQL_Command = "SELECT Name FROM Administration WHERE AdminName = '"+AdminName+"' AND Password = '"+Password+"'";
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
