package myjava;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class WorkMySql {

    private  Connection connect;

    public WorkMySql() {
        try {
            connect = DBConnection.getConnection();
            connect.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String[] args) {
//        WorkMySql mysql = new WorkMySql();
//        System.out.println("count "+ mysql.allVisits());
//        Map<String, Integer> count = mysql.getVisits();
//         for(Map.Entry<String, Integer> entry : count.entrySet()) { 
//             System.out.println(entry.getKey()+ " " + entry.getValue());
//         }
//    }

    public void addVisit(String browser) throws SQLException {
        String sql = " INSERT INTO browser_visit(`time`,`browser`) VALUES(NOW(),'" + browser + "');";
        try {
            connect.createStatement().execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int allVisits() {
        int count = 0;
        String sql = "";
        try {
            sql = "SELECT COUNT(*) FROM browser_visit ORDER BY browser ;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Map<String, Integer> getVisits() {
        Map<String, Integer> count = new HashMap<String, Integer>();
        String sql = "";
        try {
            sql = "SELECT `browser`, COUNT(*) FROM browser_visit GROUP BY `browser`;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            while(rs.next()){
              count.put(rs.getString(1),rs.getInt(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
//        public Map<String, BrowserData> getLastVisits() {
//        Map<String, BrowserData> lastDate = new HashMap<String, BrowserData>();
//        GregorianCalendar calendar = new GregorianCalendar();
//        String sql = "";
//        try {
//            sql = "SELECT `browser`, MAX(`time`) FROM browser_visit GROUP BY `browser`;";
//            ResultSet rs = connect.createStatement().executeQuery(sql);
//            while(rs.next()){
//              calendar.setTime(rs.getDate(2));  
//              lastDate.put(rs.getString(1),new BrowserData(rs.getDate(1),
//                                                   calendar.setTime(rs.getDate(2)));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lastDate;
//    }
}
