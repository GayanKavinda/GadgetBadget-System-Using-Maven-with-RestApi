function getRow() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("fund_id").value = this.cells[1].textContent;
			document.getElementById("funding_provider_name").value = this.cells[2].textContent;
			document.getElementById("contact_no").value = this.cells[3].textContent;
			document.getElementById("email").value = this.cells[4].textContent;
			document.getElementById("amount").value = this.cells[5].textContent;
			document.getElementById("address").value = this.cells[6].textContent;
		};
	}
}

function getRowSearch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("fund_id").value = this.cells[1].textContent;
			document.getElementById("funding_provider_name").value = this.cells[2].textContent;
			document.getElementById("contact_no").value = this.cells[3].textContent;
			document.getElementById("email").value = this.cells[4].textContent;
			document.getElementById("amount").value = this.cells[5].textContent;
			document.getElementById("address").value = this.cells[6].textContent;
		};
	}
}

function getID() {
	var table = document.getElementById('table');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("fund_id").value = this.cells[1].textContent;
		};
	}
}

function getIDserch() {
	var table = document.getElementById('idTable');
	for (var i = 0; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {
			document.getElementById("fund_id").value = this.cells[1].textContent;
		};
	}
}

function resetForm() {
	document.getElementById("fund_id").value = "0";
	document.getElementById("funding_provider_name").value = "";
	document.getElementById("contact_no").value = "";
	document.getElementById("email").value = "";
	document.getElementById("amount").value = "";
	document.getElementById("address").value = "";
}

function save() {
	var fund_id = $('#fund_id').val();
	fund_id = parseInt(fund_id);
	if (fund_id === 0) {
		if(ValidInput()){
			$.ajax({
				url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_management',
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
				url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_management',
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
					url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_management/' + $('#fund_id').val(),
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
					url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_management/' + $('#fund_id').val(),
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
		url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_managements',
		method : 'GET',
		headers : {
			Accept : "application/json",
			"Content-Type" : "application/json"
		},
		success : function(data, textStatus, errorThrown) {
			var items = [];
			$.each(data.fundingManagement,function(key, val) {
				var index = key + 1;
				items.push("<tr>");
				items.push("<td>" + index + "</td>");
				items.push("<td>" + val.fund_id + "</td>");
				items.push("<td>" + val.funding_provider_name + "</td>");
				items.push("<td>" + val.contact_no + "</td>");
				items.push("<td>" + val.email + "</td>");
				items.push("<td>" + val.amount + "</td>");
				items.push("<td>" + val.address + "</td>");
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
		"fund_id" : $('#fund_id').val(),
		"funding_provider_name" : $('#funding_provider_name').val(),
		"contact_no" : $('#contact_no').val(),
		"email" : $('#email').val(),
		"amount" : $('#amount').val(),
		"address" : $('#address').val(),
	});
}

function ValidInput(){
	var fund_id = $('#fund_id').val();
	var funding_provider_name = $('#funding_provider_name').val();
	var contact_no = $('#contact_no').val();
	var email = $('#email').val();
	var amount = $('#amount').val();
	var address = $('#address').val();
	var fund_id = $('#fund_id').val();
	var funding_provider_name = $('#funding_provider_name').val();
	var contact_no = $('#contact_no').val();
	var email = $('#email').val();
	var amount = $('#amount').val();
	var address = $('#address').val();
	if(fund_id === "" || funding_provider_name === "" || contact_no === "" || email === "" || amount === "" || address === ""){
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
		url : 'http://localhost:8080/funding/webresources/Funding_managementResources/Funding_management/' + searchID,
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
				items.push("<td>" + val.fund_id + "</td>");
				items.push("<td>" + val.funding_provider_name + "</td>");
				items.push("<td>" + val.contact_no + "</td>");
				items.push("<td>" + val.email + "</td>");
				items.push("<td>" + val.amount + "</td>");
				items.push("<td>" + val.address + "</td>");
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