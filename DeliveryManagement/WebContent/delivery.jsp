<%@ page import="connector.Delivery" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<%
	//insert delivery records
	if (request.getParameter("deliveryFee") != null) 
	{
		Delivery deliveryObj = new Delivery(); 
	
		String stsMsg = deliveryObj.insertDelivery(request.getParameter("deliveryFee"), 
			
			//request.getParameter("deliveryFee"),
			request.getParameter("date"), 
			request.getParameter("location"),
			request.getParameter("time"));
	 
		session.setAttribute("statusMsg", stsMsg); 
	
	}

	//Delete delivery
	if(request.getParameter("deliveryId") != null)
	{
		Delivery deliveryObj = new Delivery();
		String stsMsg = deliveryObj.deleteDelivery(request.getParameter("deliveryId"));
	}
%>

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<meta charset="ISO-8859-1">
<title>Delivery Management</title>
</head>
<body>

	<div class="container">
		<div class="row">
		<div class="col">

	<h1>Delivery Management</h1> 
	<form method="post" action="delivery.jsp"> 
		 
		<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label"> <h5>Delivery Fee:</h5> </label>
  <input type="text" class="form-control" id="formGroupExampleInput" placeholder="please enter delivery fee">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput2" class="form-label"> <h5>Date:</h5> </label>
  <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="please enter date">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput3" class="form-label"> <h5>Location:</h5> </label>
  <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="please enter location">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput4" class="form-label"> <h5>Time:</h5> </label>
  <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="please enter time">
</div>

		
		
		<input name="btnSubmit" class="btn btn-primary" type="submit" value="Save"> 
		<input name="btnReset" class="btn btn-primary" type="reset" value="Reset"> 
		
	</form> 
	
			
	
	<div class="alter alter-success">
		<%
		out.print(session.getAttribute("statusMsg")); 
		%>
	</div>
	
	<br>
	<%
	Delivery deliveryObj = new Delivery();
	out.print(deliveryObj.readDeliverys());
	%>
		</div>
		</div>
	</div>
	
</body>
</html>	