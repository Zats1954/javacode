package myjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
// String sql = " INSERT INTO browser_visit(`browser`) VALUES('" + browser + "');";       
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
            sql = "SELECT COUNT(*) FROM browser_visit;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            rs.next();
            count = rs.getInt(1);
            rs.close();
        } catch (Exception ex) {
            System.out.println(sql);
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public Map<String, Integer> getVisits() {
        Map<String, Integer> count = new HashMap<String, Integer>();
        String sql = "";
        try {
            sql = "SELECT `browser`, COUNT(*) FROM browser_visit GROUP BY `browser` ;";
            ResultSet rs = connect.createStatement().executeQuery(sql);
            while(rs.next()){
              count.put(rs.getString(1),rs.getInt(2));
            }
//            rs.next();
//            count = rs.getInt(1);
        } catch (Exception ex) {
            System.out.println(sql);
            Logger.getLogger(WorkMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
