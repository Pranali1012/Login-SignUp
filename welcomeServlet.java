package com.loginpage.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomeurl")

public class welcomeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String name=req.getParameter("your_name");
		String pass=req.getParameter("your_pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Pranali@123");
			
			String qry="select * from emplogin.emp";
			PreparedStatement ps=con.prepareStatement(qry);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String n=rs.getString(1);
				String p=rs.getString(3);
			
			
			if(name.equals(n)&&(pass.equals(p))) {
				RequestDispatcher rd=req.getRequestDispatcher("newurl");
				rd.forward(req, resp);
			}
			else {
				PrintWriter out=resp.getWriter();
				out.print("<h1>Invalid username or password"+"</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.include(req, resp);
			}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
	}
}
