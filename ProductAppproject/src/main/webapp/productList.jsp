
<%@page import="com.sathya.servlet.ProductDao" 
	import="java.util.Base64" %>
<%@ page language="java" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>Product List</title>
	<link rel="stylesheet" 
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet" >
	</head>
		
	<body style="background-color: pink;">
		
		<h1 class="text-success text-center font-italic">List Of Available Product...</h1>		
		<div>
		<a href="add-product.html" class="btn btn-success"> saveProduct </a>
		</div>
	
		<div>
		<input type="text" placeholder="search" >
		</div>
			                                                                                    
		<div>
		<c:if test="${saveResult==1}">
		<h1 class="text-success text-center"> Data Inserted Succesfully</h1>
		</c:if>
		</div>
		
		<div>
		<c:if test="${count==1}">
		<h1 class="text-danger text-center"> Data deleted succesfully</h1>
		</c:if>
		</div>
		
		<div>
		<c:if test="${count==0}">
		<h1 class="text-danger text-center"> Data deleted fail</h1>
		</c:if>
		</div>
		
	
		<table class="table table-bordered table-striped" >
		<thead class="thead-dark">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Cost</th>
			<th>Product Brand</th>
			<th>Made IN</th>
			<th>Manufacture Date</th>
			<th>ExpiryDate</th>
			<th>Image</th>
			<th>Audio</th>
			<th>Video</th>
			<th>Action</th>
								
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
			<tr>
				<td>${product.proId}</td>
				<td>${product.proName}</td>
				<td>${product.proPrice}</td>
				<td>${product.proBrand}</td>
				<td>${product.proMadeIn}</td>
				<td>${product.proMfgDate}</td>
				<td>${product.proExpDate}</td>		
				<td>
            <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="Product Image" style="max-width: 100px; max-height: 100px;">
        </td>
        
        
        
        <!-- Display audio using audio tag  -->
        <td >
        	<audio controls>
        <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio) }" type="audio/mpeg">
        	</audio>
        </td>
        
        <td >
        	<video controls width="320" height="240" >
        <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4">  
            </video>
        </td>
           
        <td>
        <a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId }">Delete</a>
        <a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId }">Edit</a>       
        </td>
        		
		</tr>
		</c:forEach>		
		</tbody>
		</table>
	</body>
</html>