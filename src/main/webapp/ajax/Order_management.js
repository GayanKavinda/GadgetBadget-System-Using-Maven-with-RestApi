function getRow() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("order_id").value = this.cells[1].textContent;
			document.getElementById("product_name").value = this.cells[2].textContent;
			document.getElementById("quantity").value = this.cells[3].textContent;
			document.getElementById("customer_name").value = this.cells[4].textContent;
			document.getElementById("customer_address").value = this.cells[5].textContent;
			document.getElementById("contact_no").value = this.cells[6].textContent;
		};
	}
}

function getRowSearch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("order_id").value = this.cells[1].textContent;
			document.getElementById("product_name").value = this.cells[2].textContent;
			document.getElementById("quantity").value = this.cells[3].textContent;
			document.getElementById("customer_name").value = this.cells[4].textContent;
			document.getElementById("customer_address").value = this.cells[5].textContent;
			document.getElementById("contact_no").value = this.cells[6].textContent;
		};
	}
}

function getID() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("order_id").value = this.cells[1].textContent;
		};
	}
}

function getIDserch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("order_id").value = this.cells[1].textContent;
		};
	}
}

function resetForm() {
	document.getElementById("order_id").value = "0";
	document.getElementById("product_name").value = "";
	document.getElementById("quantity").value = "";
	document.getElementById("customer_name").value = "";
	document.getElementById("customer_address").value = "";
	document.getElementById("contact_no").value = "";
}

function save() {
	var order_id = $('#order_id').val();
	order_id = parseInt(order_id);
	if (order_id === 0) {
		if(ValidInput()){
			$.ajax({
				url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_management',
				method : 'POST',
				headers : {
					"Content-Type" : "application/json"
				},
				data : getJSON(),
				success : function(data) {
					$("#idTable").find("tr:gt(0)").remove();
					$("#table").find("tr:gt(0)").remove();
					load();
					resetForm();
					alert(data);
				},
				error : function(jqXHR, exception) {
					alert("error");
				}
			});
		}else{
			alert("Fill form");
		}
	}else{
		if(ValidInput()){
			$.ajax({
				url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_management',
				method : 'PUT',
				headers : {
					"Content-Type" : "application/json"
				},
				data : getJSON(),
				success : function(data) {
					$("#idTable").find("tr:gt(0)").remove();
					$("#table").find("tr:gt(0)").remove();
					load();
					resetForm();
					alert(data);
				},
				error : function(jqXHR, exception) {
					alert("error");
				}
			});
		}else{
			alert("Fill form");
		}
	}
}

function delet(){
	getID();
	swal({
		title: "Are you sure?",
		text: "Do you realy want to Delete this?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_management/' + $('#order_id').val(),
					method: 'DELETE',
					success: function (resultText) {
						$("#table").find("tr:gt(0)").remove();
						$("#idTable").find("tr:gt(0)").remove();
						load();
						swal("Deleted!", {
							icon: "success",
							});
						},
						error: function (jqXHR, exception) {
							swal("fail");
						}
					});
				} else {
					swal("Safe!");
				}
			});
}

function deletSearch(){
	getIDserch();
	swal({
		title: "Are you sure?",
		text: "Do you realy want to Delete this?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_management/' + $('#order_id').val(),
					method: 'DELETE',
					success: function (resultText) {
						$("#table").find("tr:gt(0)").remove();
						$("#idTable").find("tr:gt(0)").remove();
						load();
						swal("Deleted!", {
							icon: "success",
							});
						},
						error: function (jqXHR, exception) {
							swal("fail");
						}
					});
				} else {
					swal("Safe!");
				}
			});
}

function load() {
	$.ajax({
		url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_managements',
		method : 'GET',
		headers : {
			Accept : "application/json",
			"Content-Type" : "application/json"
		},
		success : function(data, textStatus, errorThrown) {
			var items = [];
			$.each(data.orderManagement,function(key, val) {
				var index = key + 1;
				items.push("<tr>");
				items.push("<td>" + index + "</td>");
				items.push("<td>" + val.order_id + "</td>");
				items.push("<td>" + val.product_name + "</td>");
				items.push("<td>" + val.quantity + "</td>");
				items.push("<td>" + val.customer_name + "</td>");
				items.push("<td>" + val.customer_address + "</td>");
				items.push("<td>" + val.contact_no + "</td>");
				items.push("<td><button onclick='getRow()' type='button' class='btn btn-info btn-fill'>Edit</button></td>");
				items.push("<td><button onclick='delet()' type='button' class='btn btn-danger btn-fill'>Delete</button></td>");
				items.push("</tr>");
			});
		$("<tbody/>", {
			html : items.join("")
		}).appendTo("#table");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Ajax request fail");
		},
		timeout : 120000,
	});
}

function getJSON() {
	return JSON.stringify({
		"order_id" : $('#order_id').val(),
		"product_name" : $('#product_name').val(),
		"quantity" : $('#quantity').val(),
		"customer_name" : $('#customer_name').val(),
		"customer_address" : $('#customer_address').val(),
		"contact_no" : $('#contact_no').val(),
	});
}

function ValidInput(){
	var order_id = $('#order_id').val();
	var product_name = $('#product_name').val();
	var quantity = $('#quantity').val();
	var customer_name = $('#customer_name').val();
	var customer_address = $('#customer_address').val();
	var contact_no = $('#contact_no').val();
	var order_id = $('#order_id').val();
	var product_name = $('#product_name').val();
	var quantity = $('#quantity').val();
	var customer_name = $('#customer_name').val();
	var customer_address = $('#customer_address').val();
	var contact_no = $('#contact_no').val();
	if(order_id === "" || product_name === "" || quantity === "" || customer_name === "" || customer_address === "" || contact_no === ""){
		return false;
	}else{
		return true;
	}
	return true;
}

function search(){
$("#idTable").find("tr:gt(0)").remove();
	var searchID = $('#searchID').val();
	if(searchID === ""){
		alert("Please Enter ID")
	}else{
	$.ajax({
		url : 'http://localhost:8080/order/webresources/Order_managementResources/Order_management/' + searchID,
		method : 'GET',
		headers : {
			Accept : "application/json",
			"Content-Type" : "application/json"
		},
		success : function(data, textStatus, errorThrown) {
			var items = [];
			$.each(data,function(key, val) {
				var index = key + 1;
				items.push("<tr>");
				items.push("<td>" + index + "</td>");
				items.push("<td>" + val.order_id + "</td>");
				items.push("<td>" + val.product_name + "</td>");
				items.push("<td>" + val.quantity + "</td>");
				items.push("<td>" + val.customer_name + "</td>");
				items.push("<td>" + val.customer_address + "</td>");
				items.push("<td>" + val.contact_no + "</td>");
				items.push("<td><button onclick='getRow()' type='button' class='btn btn-info btn-fill'>Edit</button></td>");
				items.push("<td><button onclick='delet()' type='button' class='btn btn-danger btn-fill'>Delete</button></td>");
				items.push("</tr>");
			});
		$("<tbody/>", {
			html : items.join("")
		}).appendTo("#idTable");
	},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Ajax request fail");
		},
		timeout : 120000,
		});
	}
}