package web;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AWS")
public class AWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String time = request.getParameter("time");
		String Userid="sopac";
    	String Password="Yy336699@";
    	String a ="1";
    	
    	if (a != null) {
			Connection con=null;Statement stmt=null;
			try {
				Class.forName("org.h2.Driver");
				 con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

				 stmt = con.createStatement();

				stmt.executeUpdate("INSERT INTO AWS(Date,ID,Password) VALUES('" + time
						
						+"','" + Userid + "','" + Password + "')");
				
				
			}catch (Exception e) {
				e.printStackTrace();		
			}finally {
                try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            };		
    	
    	request.setAttribute("y", a);
		request.setAttribute("id", Userid);
		request.setAttribute("pass", Password);		
		RequestDispatcher dispatch = request.getRequestDispatcher("AWSloginID.jsp");
		dispatch.forward(request, response);
		
	}
				
    }
}
