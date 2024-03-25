package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Display the total details
		//total 6=req(2) cookies(4)
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		Cookie[] cookies=request.getCookies();
		writer.println("<html>");
		writer.println("<body bgcolor=yellow>");
		
		writer.print("<pre style=color:purple>");
		writer.println("User name....."+cookies[0].getValue());
		writer.println("Age......."+cookies[1].getValue());
		writer.println("Qualification ......"+cookies[2].getValue());
		writer.println("Disignation ........."+cookies[3].getValue());
		writer.println("Email ......."+request.getParameter("Email"));
		writer.println("Mobile ........"+request.getParameter("mobile"));
		writer.print("</pre>");
		writer.println("</body>");
		writer.println("</html>");		
		
		
		
		
	}

}
