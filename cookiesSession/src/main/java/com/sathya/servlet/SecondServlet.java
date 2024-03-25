package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        		//get the data requested from data
				String qualification=request.getParameter("Qualification");
				String designation=request.getParameter("Designation");
	
				//create the cookies objects
	
				Cookie cookie1=new Cookie("Qualification",qualification );
				Cookie cookie2=new Cookie("Designation",designation);
			
				//add the cookies into responce object
			
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				//place the data into session object
				RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
				dispatcher.forward(request, response);		
	}

}
