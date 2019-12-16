package myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.*;


public class DBConnection
{
    private static Connection connection;

    private static final String DB_NAME = "browser";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Zats1954";

    public static Connection getConnection() throws ClassNotFoundException
    {
        if(connection == null)
        {   
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
//                DriverManager.registerDriver(com.mysql.jdbc.Driver);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME ,
                  DB_USER ,DB_PASS);
                connection.createStatement().execute("CREATE TABLE " +
                    "IF NOT EXISTS browser_visit(id INT NOT NULL AUTO_INCREMENT," +
                    "`time` DATETIME, `browser` VARCHAR(25), PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}