package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				String proId=request.getParameter("proId");
				
				ProductDao productDao=new ProductDao();
				Product existingproduct=productDao.findById(proId);
				
				 //send the product object data should be edit-form
				request.setAttribute("existingproduct",existingproduct );
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("edit-form.jsp");
				dispatcher.forward(request, response);
				
	}
}
