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
					<li><a href="new-task">New Task</a></li>
					<li><a href="all-tasks">All Tasks</a></li>
					<li><a href="new-hotel">New Hotel</a></li>
					<li><a href="all-hotels">All Hotels</a></li>
					<li><a href="new-employee">New Employees</a></li>
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
		<c:when test="${mode=='MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Tasks</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
								<th>Date created</th>
								<th>Finished</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td>${task.id}</td>
									<td>${task.name}</td>
									<td>${task.description}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${task.dateCreated}" /></td>
									<td>${task.finished==true?"YES":"NO"}</td>
									<td><a href="update-task?id=${task.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-task?id=${task.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Task</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-task">
					<input type="hidden" name="id" value="${task.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${task.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Description:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${task.description}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Finished:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="finished"
								value="true" />
								<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="finished"
								value="false" checked="checked"/>
								<div class="col-sm-2">NO</div>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
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
		
		
		
		
		
		
		
		
		
		
		<c:when test="${mode=='MODE_EMPLOYEES'}">
			<div class="container text-center" id="employeesDiv">
				<h3>My Employees</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Role</th>
								<th>Age</th>
								<th>Date created</th>
								<th>Attended</th>
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
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${employee.dateCreated}" /></td>
									<td>${employee.attended==true?"YES":"NO"}</td>
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
						<label class="control-label col-sm-3">Attended:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="attended"
								value="true" />
								<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="attended"
								value="false" checked="checked"/>
								<div class="col-sm-2">NO</div>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>
	
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>
