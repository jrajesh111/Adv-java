package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		             //get the data from the clint 
				String qualification=request.getParameter("Qualification");
				String designation=request.getParameter("Designation");
				
						//create the httpsession object
				
						HttpSession session=request.getSession();
						
						//set the data into session object
						
						session.setAttribute("Qualification", qualification);
						session.setAttribute("Designation", designation);		
					//place the data into session object
						RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
						dispatcher.forward(request, response);
		
		
	}

}
