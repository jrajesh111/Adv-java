package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//get the data from the clint 
		String username=request.getParameter("username");
		int age=Integer.parseInt(request.getParameter("age"));
		
				//create the httpsession object
		
				HttpSession session=request.getSession();
				
				//set the data into session object
				
				session.setAttribute("username", username);
				session.setAttribute("age", age);		
			//place the data into session object
				RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
				dispatcher.forward(request, response);
	}

}
