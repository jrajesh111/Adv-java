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

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
					//get the data requested from data 
					String username=request.getParameter("username");
					String age=request.getParameter("age");
						//create the cookies objects
				
						Cookie cookie1=new Cookie("username",username );
						Cookie cookie2=new Cookie("age",age);
						
						//add the data cookies into response object
						response.addCookie(cookie1);
						response.addCookie(cookie2);
						
					//place the data into session object
						RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
						dispatcher.forward(request, response);
		
		
		
	}

}
