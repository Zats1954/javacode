<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.logging.Logger"%>
<%
class DBConnection
{
    Connection connection;

    String dbName = "browser";
    String dbUser = "root";
    String dbPass = "Zats1954";

    Connection getConnection()
    {
        if(connection == null)
        {   
            try {
                     connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                    "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("CREATE TABLE " +
                    "IF NOT EXISTS browser_visit(id INT NOT NULL AUTO_INCREMENT," +
                    "`time` DATETIME, `browser` VARCHAR(25), PRIMARY KEY(id))");
            } catch (SQLException e) {
                System.out.println("Error connection" );
                e.printStackTrace();
            }
        }
        return connection;
    }
} %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
