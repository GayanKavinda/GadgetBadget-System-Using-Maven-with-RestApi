<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Order</title>
</head>
<body onload="load()">
	<section class="forms">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header d-flex align-items-center">
							<h3 class="h4">order management</h3>
						</div>
						<div class="card-body">
							<form class="form-horizontal">
								<div class="form-group row">
									<div class="col-sm-9">
										<input id="order_id" type="hidden" value="0"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 form-control-label">product name</label>
									<div class="col-sm-9">
										<input id="product_name" type="text"
											placeholder="product name"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 form-control-label">quantity</label>
									<div class="col-sm-9">
										<input id="quantity" type="text" placeholder="quantity"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 form-control-label">customer
										name</label>
									<div class="col-sm-9">
										<input id="customer_name" type="text"
											placeholder="customer name"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 form-control-label">customer
										address</label>
									<div class="col-sm-9">
										<input id="customer_address" type="text"
											placeholder="customer address"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-3 form-control-label">contact no</label>
									<div class="col-sm-9">
										<input id="contact_no" type="text" placeholder="contact no"
											class="form-control form-control-warning">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-9 offset-sm-3">
										<input onclick="save()" type="button" value="Save"
											class="btn btn-primary"> <input type="reset"
											value="Reset" class="btn btn-primary">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="card">
						<div class="card-header d-flex align-items-center">
							<h3 class="h4">History</h3>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-hover" id="table">
									<thead>
										<tr>
											<th>#</th>
											<th>order id</th>
											<th>product name</th>
											<th>quantity</th>
											<th>customer name</th>
											<th>customer address</th>
											<th>contact no</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="card">
						<div class="card-header d-flex align-items-center">
							<div class="input-group mb-3">
								<input id="searchID" type="Number" class="form-control"
									placeholder="Search by ID" aria-describedby="basic-addon2">
								<div class="input-group-append">
									<button onclick="search()" class="btn btn-outline-secondary"
										type="button">Search</button>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-hover" id="idTable">
									<thead>
										<tr>
											<th>#</th>
											<th>order id</th>
											<th>product name</th>
											<th>quantity</th>
											<th>customer name</th>
											<th>customer address</th>
											<th>contact no</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="ajax/jquery.3.2.1.min.js"></script>
	<script src="ajax/ajax.js"></script>
	<script src="ajax/Order_management.js"></script>
	<script src="sweetalert/sw.js"></script>
</body>
</html>