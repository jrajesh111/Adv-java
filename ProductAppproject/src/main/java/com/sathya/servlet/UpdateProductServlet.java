package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
@SuppressWarnings("serial")
@WebServlet("/UpdateProductServlet")
@MultipartConfig 
public class UpdateProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				//Read the Data
				String proId=request.getParameter("proId");
				String proName=request.getParameter("proName");
				
				double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				String proBrand=request.getParameter("proBrand");
				String proMadeIn=request.getParameter("proMadeIn");				
				Date proMfgDate=Date.valueOf(request.getParameter("MfgDate"));
				Date proExpDate=Date.valueOf(request.getParameter("ExpiryDate"));	
				//Using above details create the product object
				Product product=new Product();	
				product.setProId(proId);
				product.setProName(proName);
				product.setProPrice(proPrice);
				product.setProBrand(proBrand);
				product.setProMadeIn(proMadeIn);
				product.setProMfgDate(proMfgDate);
				product.setProExpDate(proExpDate);
									
				Part filePart = request.getPart("newProImage");	//newproimage is the name of your file input field
				
				if(filePart!=null && filePart.getSize()>0) {
					
					InputStream inputStream=filePart.getInputStream();
					byte[] newImageDate =IOUtils.toByteArray(inputStream);
					product.setProImage(newImageDate);
				}
				else {
					
					//Part file =request.getPart("existingImage");
					//InputStream inputStream=file.getInputStream();
					//byte[] existingImage =IOUtils.toByteArray(inputStream);
					
					String s=request.getParameter("existingImage");				
					byte[] existingImage=Base64.getDecoder().decode(s); 
					product.setProImage(existingImage);
				}
				//Giving the product object to DAO Layer
				ProductDao productDao=new ProductDao();
				
				int result=productDao.updateById(product);
				
				if(result==1)
				{	
					RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
					dispatcher.forward(request, response);	 				
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("Data Updation fail check once...."+result);						
					RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");	
				}	
	}
}
