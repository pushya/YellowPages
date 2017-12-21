import java.util.*;
import java.sql.*;

public class DBConnection {
    Connection conn;
    String url,ucid,dbpassword;
    public DBConnection {
        
        url = "sql2.njit.edu";
        ucid = "nhp32";
        dbpassword = "f8V3ysk2";
    }
    public Connection openConnection(){
    
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://"+url+"/"+ucid+"?user="+ucid+"&password="+dbpassword);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS Account");
            stmt.executeUpdate("CREATE TABLE Account("+
                               "idnum INT NOT NULL AUTO_INCREMENT, "+
                               "PRIMARY KEY(idnum), "+
                               "username VARCHAR(15) UNIQUE NOT NULL, "+
                               "password VARCHAR(15) NOT NULL, "+
                               "name VARCHAR(15) NOT NULL, "+
                               "phoneno VARCHAR(10) NOT NULL, "+
                               "address VARCHER(30) NOT NULL, "+
                               "message TEXT)");
            stmt.executeUpdate("CREATE TABLE Administration("+
                               "PRIMARY KEY(idnum), "+
                               "username VARCHAR(15) UNIQUE NOT NULL, "+
                               "password VARCHAR(15) NOT NULL)");
            stmt.executeUpdate("INSERT INTO Administration (idnum, adminname, password) "+
                               "VALUES(\"root\", \"root\"");
            stmt.close();
            conn.close();
        }
        catch (SQLException E) {
            System.out.println("SQLException: " + E.getMessage());
            System.out.println("SQLState:     " + E.getSQLState());
            System.out.println("VendorError:  " + E.getErrorCode());
        }
        catch (Exception e) {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }
    }
}
