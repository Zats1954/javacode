/**
 *
 * @author Alexander
 */
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
}
