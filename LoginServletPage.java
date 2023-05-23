package com.loginpage.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")

public class LoginServletPage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Pranali@123");
			System.out.println("connected");
			String qry="insert into emplogin.emp values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);
			pstmt.execute();
			System.out.println("created and inserted");
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out=resp.getWriter();
		out.print("<h1> Registered successfully" +"</h1>");
	
		
	}
}
