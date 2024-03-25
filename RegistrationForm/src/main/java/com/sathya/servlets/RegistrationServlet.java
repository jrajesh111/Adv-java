package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	long mobileno=Long.parseLong(request.getParameter("mobile"));
	String Email=request.getParameter("email");
	String gender=request.getParameter("Gender");
	String dob=request.getParameter("dob");
	String qualification[]=request.getParameterValues("qualifiction");
	String country=request.getParameter("country");
	String lang=request.getParameter("Language");
	String comment=request.getParameter("comments");
	//step 2: process the data
	String q=String.join(",", qualification);
	String l=String.join(",", lang);
	
	//step-3 render the responce
	response.setContentType("text/html");
	PrintWriter writer=response.getWriter();
	writer.println("<html>");
	writer.println("<body bgcolor="+"pink"+">"+"<br>");
	writer.print("<h1> Registration Form</h1>");
	writer.println("Your name :"+username+"<br>");
	writer.println("Enter the pwd"+password+"<br>");
	writer.println("Enter the mail  "+Email+"<br>");
	writer.println("Enter the mobile no "+mobileno+"<br>");
	
	writer.println("Enter the gender "+gender+"<br>");
	writer.println("Enter the dob "+dob+"<br>");
	writer.println("Enter the Qualification"+q+"<br>");
	writer.println("Enter the country "+country+"<br>");
	writer.println("Enter the Language "+l+"<br>");
	writer.println("Enter the comments "+comment+"<br>");
	
	writer.println("</body>");
	writer.println("</html>");	

}
}
