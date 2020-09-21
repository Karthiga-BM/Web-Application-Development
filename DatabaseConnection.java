package onlinedatingsite;

import java.sql.*;


 
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    protected static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "oracle.jdbc.driver.OracleDriver"; 
        String dbURL = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
                        
        // Database name to access 
        String dbName = "karreg"; 
        String dbUsername = "ee_user"; 
        String dbPassword = "ee_pass"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL, 
                                                     dbUsername,  
                                                     dbPassword); 
        System.out.println("connection successful");
        return con; 
    } 
    
 
} 