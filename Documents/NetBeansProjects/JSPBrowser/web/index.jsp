<%-- 
    Document   : index
    Created on : Sep 3, 2019, 2:48:47 PM
    Author     : Alexander
--%>

<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="myjava.WorkMySql"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Browser's statistic</h1>
<%! WorkMySql workSQL = new WorkMySql(); %>
<% long time = new Date().getTime(); %>
<%      Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String browser = "   ";
            if(key.equals("user-agent")){
                String value = request.getHeader(key);
                out.println(key + ":");
                out.println(value);
                if( value.indexOf("Firefox") >-1 ){
                    browser = "Firefox";                    
                } else if ( value.indexOf("Trident") >-1 ){
                    browser = "InternetExplorer"; 
                }else if ( value.indexOf("OPR") >-1 ){
                    browser = "Opera"; 
                }else if ( value.indexOf("Chrome") >-1 ){
                    browser = "GoogleChrome"; 
                }else {
                    browser = "Unknown"; 
                }
//                workSQL.addVisit(browser);
            }
        } %>
    <br/><br/>
<table style="border: 2px solid; border-collapse: collapse">                  
 <%         Map<String,Integer> sostav = workSQL.getVisits();
          for(Map.Entry<String, Integer> entry : sostav.entrySet()) { %>
     <tr>
         <td style="border: 2px solid; padding: 5px"> <%= entry.getKey() %> </td>
         <td style="border: 2px solid; padding: 5px; text-align: right;"> <%= entry.getValue() %> </td>
     </tr>    
 <%         } 
 %>
    </table>
    <hr/>
 Число посещений -  <%= workSQL.allVisits() %>

 <% long times = new Date().getTime() - time;%>
 Время - 
 <%= times %>
    </body>
</html>
