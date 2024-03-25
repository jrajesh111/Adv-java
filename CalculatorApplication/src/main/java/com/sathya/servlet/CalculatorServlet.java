package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	int num1=Integer.parseInt(request.getParameter("First"));
	int num2=Integer.parseInt(request.getParameter("secound"));
	String operation=request.getParameter("Operation");
	
	int result=0;
	switch(operation) {
		case "+" :result=num1+num2;
			break;
		case "-" :result=num1-num2;
			break;
		case "*" :result=num1*num2;
			break;
		case "%" :result=num1%num2;
			break;
		case "/" :result=num1/num2;
			break;		
	}
//		render the responce
	
	response.setContentType("text/html");
	PrintWriter writer=response.getWriter();
	writer.println("<html>");
	writer.println("<body bgcolor=\"pink\">");
	writer.println("<h1>Your Result</h1>");
	writer.println("first number :"+num1+"<br>");
	writer.println("second number :"+num2+"<br>");
	writer.println("operation :"+operation+"<br>");
	writer.println("Your result is :"+result);
	writer.println("</body>");
	writer.println("</html>");
	} 
}
