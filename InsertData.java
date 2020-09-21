package onlinedatingsite;


import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
  
// Import Database Connection Class file 
import onlinedatingsite.DatabaseConnection; 
  
// Servlet Name 
@WebServlet("/InsertData") 
public class InsertData extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
  
    protected void doPost(HttpServletRequest request,  
HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        try { 
  
            // Initialize the database 
            Connection con = DatabaseConnection.initializeDatabase(); 
        
            // Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
            PreparedStatement st = con 
                   .prepareStatement("insert into karreg values(?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
            st.setString(1, request.getParameter("firstname")); 
            st.setString(2, request.getParameter("lastname")); 
            st.setString(3, request.getParameter("email")); 
            st.setString(4, request.getParameter("password")); 
            st.setString(5, request.getParameter("confirmpassword")); 
            st.setInt(6, Integer.valueOf(request.getParameter("contact"))); 
            st.setString(7, request.getParameter("iam"));
            st.setInt(8, Integer.valueOf(request.getParameter("age"))); 
            st.setString(9, request.getParameter("country")); 

            
            /*PreparedStatement st = con 
                    .prepareStatement("insert into karreg values(?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
             st.setString(1, "Karthy"); 
             st.setString(2, "sad"); 
             st.setString(3, "email"); 
             st.setString(4, "Pass");
             st.setString(5, "Confir"); 
             st.setInt(6, Integer.valueOf("889")); 
             st.setString(7,"wadw");
             st.setInt(8, Integer.valueOf("0")); 
             st.setString(9, "asf");*/

  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
  
            // Same for second parameter 
  
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
            // Get a writer pointer  
            // to display the successful result 
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
