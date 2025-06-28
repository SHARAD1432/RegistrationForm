package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm") 
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Here we get values through the request
		
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		String mygender=req.getParameter("gender1");
		String mycity=req.getParameter("city1");
		
		PrintWriter  out=resp.getWriter();
		
		// Here we did Database connectivity with MySQL
		
		try {
             //Load and register driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create connection and add jar
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "Self@2124");
		
			 // create Prepared Statement (?= positional Parameter)
			 PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
			 
			 ps.setString(1, myname);
			 ps.setString(2, myemail);
			 ps.setString(3, mypass);
			 ps.setString(4, mygender);
			 ps.setString(5, mycity);
			 
			 // here we check valued insert or not
			 int count=ps.executeUpdate();
			 if(count>0) {
				 resp.setContentType("text/html");
				 out.println("<h3 style='color:green'>User successfully register</h3>");
				 RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
				 rd.include(req, resp);
			 }
			 else {
				 resp.setContentType("text/html");
				 out.println("<h3 style='color:red'>User not register</h3>");
				 RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
				 rd.include(req, resp);
			 }
		}
		
		catch(Exception e) {
			e.printStackTrace();
			 
			resp.setContentType("text/html");
			 out.println("<h3 style='color:red'> Exception Occurs"+ e.getMessage()+"</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
			 rd.include(req, resp);
			
		}
	}
}
