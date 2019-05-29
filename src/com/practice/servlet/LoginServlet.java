package com.practice.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I'm in Service");
		
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		System.out.println("Login details entered...................");
		
		boolean isExist = false;
		try {
			System.out.println(1);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(2);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println(3);
			Statement stmt = con.createStatement();
			System.out.println(4);
			String sql = "select username , password from users where username='"+ un+"' + password = '"+pwd+"'";
			System.out.println("Query is  >> "+sql);
			System.out.println(5);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(6);
		
			System.out.println(7);
			if (rs.next()) {
				System.out.println(8);
				isExist = true;
			}
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("is exist >>>> "+isExist);

		if (isExist) {
			String names[] = new String[3];
			names[0] = "1111";
			names[1] = "2222";
			names[2] = "3333";
			request.setAttribute("data", names);
			System.out.println("inside if ... ");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "your uname and password are wrong");
			System.out.println("inside else ... ");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		// navigate to other page
	}
}
