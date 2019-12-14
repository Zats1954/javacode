<%-- 
    Document   : WorkMySql
    Created on : Sep 7, 2019, 9:03:16 PM
    Author     : Alexander
--%>

<%@page import="myjava.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.util.HashMap" %>
<%@page import= "java.util.Map" %>
<%@page import= "java.util.logging.Level" %>
<%@page import= "java.util.logging.Logger" %>


<%
      class WorkMySql {
          
          private final Connection connect = DBConnection.getConnection();
          public WorkMySql() {
              System.out.println("WorkMySql created");
    }

    public void addVisit(String browser) {
        String sql = " INSERT INTO browser_visit(`time`,`browser`) VALUES(NOW(),'" + browser + "');";
        try {
            connect.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int allVisits() {
        int count = 0;
        String sql = "";
        try {
            sql = "SELECT COUNT(*) FROM browser_visit;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            rs.close();
        } catch (SQLException ex) {
            System.out.println(sql);
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Map<String, Integer> getVisits() {
        Map<String, Integer> count = new HashMap<>();
        String sql = "";
        try {
            sql = "SELECT `browser`, COUNT(*) FROM browser_visit GROUP BY `browser` ;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            while(rs.next()){
              count.put(rs.getString(1),rs.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
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
