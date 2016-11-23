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
					
					<li><a href="new-employee">New Employ</a></li>
					<li><a href="all-employees">All Employees</a></li>
					
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_EMPLOYEES'}">
			<div class="container text-center" id="employeesDiv">
				<h3>My Employees</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id Employe</th>
								<th>Name</th>
								<th>Role</th>
								<th>Age</th>
				
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="employee" items="${employees}">
								<tr>
									<td>${employee.id}</td>
									<td>${employee.name}</td>
									<td>${employee.role}</td>
									<td>${employee.age}</td>
									<td><a href="update-employee?id=${employee.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-employee?id=${employee.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_E' || mode=='MODE_UPDATE_E'}">
			<div class="container text-center">
				<h3>Manage Employee</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-employee">
					<input type="hidden" name="id" value="${employee.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${employee.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Role:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="role"
								value="${employee.role}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Age:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="age"
								value="${employee.age}" />
						</div>
					</div>


					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>