<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="mainpackage.Loader"%>

<% long ldt= (new Date()).getTime(); %>
<%   String filePath = application.getRealPath("/"); %>
<%   Loader.Rascet(filePath); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th {
                border: 2px solid black;
                border-collapse: collapse;
            }
            table {
                width: 30em;
            }
            td {
                border: 1px solid black;
                width: 50px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <table > 
            <tr> 
                <th>Polling stations </th>    
                    <%       for (String den : Loader.dni) {%>   
                <th>
                    <% String d = den;%> 
                    <%= d%>
                </th>
                <% } %>            
            </tr> 

            <%  Set stationSet = Loader.vyvod.entrySet();
                Iterator it = stationSet.iterator();
                while (it.hasNext()) {
                    Map.Entry me = (Map.Entry) it.next();
                    ArrayList<String> casy = (ArrayList<String>) me.getValue();
                    Iterator li = casy.iterator();
            %>        
            <tr>
                <td>
                    <%= (Integer) me.getKey()%>
                </td>
                <%  while (li.hasNext()) {
                    {%>
                <td>
                    <%= li.next()%>
                </td>
                <% }
                }%>
            </tr>
            <%  }%>
        </table>
        Compilation time - 
            <% long ndt = (new Date()).getTime(); 
                 ndt-=ldt;   %>
            <%= ndt %>  
            msec
    </body>
</html>
