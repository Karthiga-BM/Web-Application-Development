package onlinedatingsite;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

@WebServlet("/SearchDaoTest") 

public class SearchDaoTest extends HttpServlet{ 
 
 public void doPost(HttpServletRequest request, 
  HttpServletResponse response)
  throws ServletException,IOException{
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();

  System.out.println("Database Connect Example.");
  Connection conn = null;
  String dburl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
  String dbName = "karreg";
  String dbdriver = "oracle.jdbc.driver.OracleDriver";
  String userName = "ee_user"; 
  String password = "ee_pass";

  
  Statement st;
  try {
  Class.forName(dbdriver);
  conn = DriverManager.getConnection(dburl, userName, password);
  System.out.println("Connected to the database");
  String  iam  = request.getParameter("iam");
  String  country  = request.getParameter("country");
//  String age=request.getParameter("age");
  

  ArrayList al=null;
  ArrayList user_list =new ArrayList();
  String query = "select * from karreg where iam='"+iam+"'  or country='"+country+"'order by iam";
  System.out.println("query " + query);
  st = conn.createStatement();
  ResultSet  rs = st.executeQuery(query);

  while(rs.next())
  {
  al  = new ArrayList();
  
  al.add(rs.getString(1));
  al.add(rs.getString(2));
  al.add(rs.getString(3));
//  al.add(rs.getString(4));
//  al.add(rs.getString(5));
  al.add(rs.getString(6));
  al.add(rs.getString(7));
  al.add(rs.getString(8));
  al.add(rs.getString(9));
  System.out.println("al :: "+al);
  user_list.add(al);
  }

  request.setAttribute("userList",user_list);
  
 System.out.println("userList " + user_list);

  // out.println("user_list " + user_list);

  String nextJSP = "/viewResult.jsp";
  RequestDispatcher dispatcher = 
   getServletContext().getRequestDispatcher(nextJSP);
  dispatcher.forward(request,response);
  conn.close();
  System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
  }
 
}