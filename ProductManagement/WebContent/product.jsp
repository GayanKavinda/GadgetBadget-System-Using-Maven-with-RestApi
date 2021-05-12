<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.productManagement.model.Product"%>
    
<%
	if(request.getParameter("productCode") != null)
	{
		
		Product product = new Product();
	
		String stsmsg = product.insertProduct(request.getParameter("productCode"),
				request.getParameter("productName"),
				request.getParameter("productPrice"),
				request.getParameter("quanti"),
				request.getParameter("des"),
				request.getParameter("researcherName"));
		
		session.setAttribute("statusMsg",stsmsg);	
	}

	if(request.getParameter("pID") != null)
	{
		Product product = new Product();
		String stsmg = product.deleteProduct(request.getParameter("pID"));
		
		session.setAttribute("statusMsg", stsmg);
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<link href = "css/bootstrap.min.css" rel = "stylesheet">
	<script src = "js/jquery-3.4.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/FormValidation.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
<title>Product</title>
</head>

<body>
	<div class="container">
	
		<h1>Product Management</h1>
	
		
	<form method = "post" action = "product.jsp">
		<div class="form-group">
			<label for="code">Product Code </label>
			<input name = "productCode" type = "text" class = "form-control" id = "productCode" placeholder = "Enter Product Code..">
		</div>
		
		<div class="form-group">
			<label for="name">Product Name </label>
			<input name = "productName" type = "text" class = "form-control" id = "productName" placeholder = "Product Name..">
		</div>
		
		<div class="form-group">
			<label for="price">Product Price </label>
			<input name = "productPrice" type = "text" class = "form-control" id = "productPrice" placeholder = "Enter Product Price..">
		</div>
		
		<div class="form-group">
			<label for="quan">Quantity </label>
			<input name = "quanti" type = "text" class = "form-control" id = "quanti" placeholder = "Enter Quantity..">
		</div>
		
		<div class="form-group">
			<label for="desc">Description </label>
			<input name = "des" type = "text" class = "form-control" id = "des" placeholder = " Description..">
		</div>
		
		<div class="form-group">
			<label for="researcherName">Researcher Name </label>
			<input name = "researcherName" type = "text" class = "form-control" id = "researcherName" placeholder = " Researcher Name..">
		</div>
		
		<input name="btnSubmit" type="submit" value="Save" class = "btn btn-primary">
	</form>
	
	<div class = "alter alter-success">
		<%
			out.print(session.getAttribute("statusMsg"));
	
		%>
	</div>
	<br>
	<%
		Product product = new Product();
		out.print(product.readProducts());
	%>
	
	</div>
</body>
</html>