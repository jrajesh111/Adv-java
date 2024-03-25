package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FullNameApp")
public class FullNameApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FullNameApp() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Firstname=request.getParameter("first name");
		String Middlename=request.getParameter("middle name");
		String Lastname=request.getParameter("last name");
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=\"blue\">");
		writer.println("<h1>Your Full Name Is:</h1>"+Firstname+" "+Middlename+" "+Lastname);
		writer.println("</body>");
		writer.println("</html>");
	    
	}
}
