<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
	<link rel="stylesheet" 
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>
		
	<div class="container mt-5 text-center">
	
		<h2 class="text-left font-italic mb-1">Edit product Data.....</h2>
	
		<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proId">Product ID </label>
		<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingproduct.proId}" required>		
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proName">Product Name </label>
		<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingproduct.proName}" required>		
		</div> 
		
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proPrice">Product Price </label>
		<input type="text" class="form-control-sm" id="proPrice" name="proPrice" value="${existingproduct.proPrice}" required>		
		</div>		
	
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proBrand">Product Brand </label>
		<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingproduct.proBrand}" required>
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proMadeIn">MadeIn </label>
		<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingproduct.proMadeIn}" required>		
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="Manufacturing Date">MAG Date </label>
		<input type="date" class="form-control-sm" id="Manufacturing Date" name="MfgDate" value="${existingproduct.proMfgDate}" required>
		</div>
		
	
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="Expiry Date">EXP Date </label>
		<input type="date" class="form-control-sm" id="Expiry Date" name="ExpiryDate" value="${existingproduct.proExpDate}" required>
		</div>
		
		<!--Display the current product image  -->
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="proImage"> Current Product Image:</label>
		<img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" alt="Current Product Image" style="max-width: 100px; max-height: 100px;">
		<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}" />
		</div>
		
		<!-- Allow the user to uploud a new image -->
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="newProImage" >New Product Image:</label>
		<input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
		</div>
		
		  <div class="form-group">
		<label class="font-italic font-weight-bold" for="newProAudio" >New Product Audio:</label>
		<input type="file" class="form-control-file-sm" id="newProAudio" name="newProAudio" accept="audio/*">
		</div>	
	
		<div >		
		<input type="submit" class="btn btn-success" value="Update product"> 
		
		<!--  	<a href="productList.jsp" class="btn btn-primary"> List of Product</a>  -->
		</div>
				
		</form>		
		</div>
</body>
</html>