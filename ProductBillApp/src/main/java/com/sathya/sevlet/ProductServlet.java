package com.sathya.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step 1:read the request data
		
		int proid=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		//step-2: process the data
		
		double totalbill=proPrice*proQuantity;
		
		double discount=0;
		double netamount=0;
		if(totalbill<1000)
		{
			discount=0;
			netamount=totalbill-(totalbill*discount);
		}
		else if(totalbill>1000 && totalbill<5000){
			discount=0.05d;
			netamount=totalbill-(totalbill*discount);
		}else if(totalbill>5000 && totalbill<10000) {
			discount=0.1d;
			netamount=totalbill-(totalbill*discount);
		}else {
			discount=0.15d;
			netamount=totalbill-(totalbill*discount);
		}
		//step 3:Render the responce 
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=\"pink\">");
		writer.print("<h1>Product Bill Invoice</h1>");
		
		writer.println("<proId :"+ proid);
		writer.println("<br><br>");
		writer.println("proName :"+proName);
		writer.println("<br><br>");
		writer.println("proPrice :"+proPrice);
		writer.println("<br><br>");
		writer.println("proQuantity :"+proQuantity);
		writer.println("<br><br>");
		writer.println("totalbill amount" +totalbill);
		writer.println("<br><br>");
		writer.println("discount amount :" +discount);
		writer.println("<br><br>");
		writer.println("netamount :"+netamount);
		writer.println("<br><br>");
		writer.println("</body>");
		writer.println("</html>");	
	}
}
