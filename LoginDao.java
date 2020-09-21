package onlinedatingsite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class LoginDao {
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dburl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
        String dbName = "karreg";
        String dbdriver = "oracle.jdbc.driver.OracleDriver";
        String dbuserName = "ee_user";
        String dbpassword = "ee_pass";
        try {
            Class.forName(dbdriver);
            conn = DriverManager.getConnection(dburl, dbuserName, dbpassword);
            System.out.println("connection successful");


            pst = conn
                    .prepareStatement("select * from karreg where firstname=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();
            //easwar code
//            
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
//            while (rs.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = rs.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println("");
//            }
          //easwar code ends here

        } catch (Exception e) {
            System.out.println("connection is noot successful");

            System.out.println(e);
            
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
    public static void main(String args[]) {
    	LoginDao.validate("Sam", "123");
    }
}