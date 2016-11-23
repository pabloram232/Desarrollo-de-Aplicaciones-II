
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="new-employee">New Hotel</a></li>
					<li><a href="all-employees">All Hotel</a></li>
					
					
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME_H'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to hotel</h1>
				</div>
			</div>
		</c:when>

<c:when test="${mode=='MODE_HOTELS'}">
			<div class="container text-center" id="hotelsDiv">
				<h3>My hotels</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Telephone</th>
								
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="hotel" items="${hotels}">
								<tr>
									<td>${hotel.id}</td>
									<td>${hotel.name}</td>
									<td>${hotel.address}</td>
										<td>${hotel.telephone}</td>
									
									<td><a href="update-hotel?id=${hotel.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-hotel?id=${hotel.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_H'|| mode=='MODE_UPDATE_H'}">
			<div class="container text-center">
				<h3>Manage Hotel</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-hotel">
					<input type="hidden" name="id" value="${hotel.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${hotel.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Address:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="address"
								value="${hotel.address}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Telephone:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="telephone"
								value="${hotel.telephone}" />
						</div>
					</div>

					
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
			</c:choose>
		