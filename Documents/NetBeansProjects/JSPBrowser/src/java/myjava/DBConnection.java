package myjava;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.mysql.cj.jdbc.*;


public class DBConnection
{
    private static Connection connection = null;

    private static final String DB_NAME = "browser";
    private static final String DB_USER = "*******";
    private static final String DB_PASS = "*******";


    public static Connection getConnection() 
    {
        if(connection == null)
        {   
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                 String connectionString = "jdbc:mysql://localhost:3306/" + DB_NAME +
                    "?useLegacyDatetimeCode=false&serverTimezone=UTC";
                connection = DriverManager.getConnection(connectionString ,DB_USER ,DB_PASS);
                connection.createStatement().execute("CREATE TABLE " +
                    "IF NOT EXISTS browser_visit(id INT NOT NULL AUTO_INCREMENT," +
                    "`time` DATETIME, `browser` VARCHAR(25), PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}