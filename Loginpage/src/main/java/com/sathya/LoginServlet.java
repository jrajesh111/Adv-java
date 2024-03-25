package com.sathya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String status;
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		if(username.equals("Rajesh")&&password.equals("Rajesh123"))
		{
			//status="Login is succesful....";
			
//			RequestDispatcher dispatcher=request.getRequestDispatcher("Success.html");
//			dispatcher.forward(request, response);
			//response.sendRedirect("http://www.tcs.com");
			
			
			writer.println("login succesful <br>");
			writer.println("<a href='http://www.wipro.com'>Click here to wipro.com</a>");
		}else {
//			status="Login is Fial....";
//			response.setContentType("Text/html");
//			PrintWriter writer=response.getWriter();
//			writer.println("login fail check created once");
//			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
//			dispatcher.include(request, response);	
			//response.sendError(808,"Login fail check the details rejesh");
			
			
			writer.println("Login Fail <br>");
			writer.println("<a href='Login.html'>click here to login page </a>");
		}
//		response.setContentType("text/html");
//		PrintWriter writer=response.getWriter();
//		
//		writer.println("</html>");
//		writer.println("<h1>Login status....</h1>"+status);
//		writer.println("</html>");
	}	
}
