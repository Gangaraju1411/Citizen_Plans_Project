<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h3 class="mb-3">Report Application</h3>
		<form:form action="fetch" modelAttribute="search" method="post">

			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="Plan_Name">
							<form:option value="">--select--</form:option>
							<form:options items="${names}" />
						</form:select></td>

					<td>Plan Status:</td>
					<td><form:select path="Plan_Status">
							<form:option value="">--select--</form:option>
							<form:options items="${status}" />
						</form:select></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">--select--</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Fe-Male</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date" /></td>

				</tr>
				<tr>
					<td>End Date:</td>
					<td><form:input path="endDate" type="date" /></td>

				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a>
					<td><input type="submit" value="Search"
						class=" btn btn-primary"></td>

					<!--	<td><a href="/data" class="btn btn-primary">Search</a>  -->



				</tr>

			</table>

		</form:form>

		<hr />
		<table class="table table-bordered border-primary">>
			<thead>
				<tr>
					<th>S.No</th>
					<th>Citizen Id</th>

					<th>Holder Name</th>
					<th>Gender</th>

					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>BENEFIT_AMOUNT</th>
					<!--  
					<th>Denial Reason</th>

					<th>Terminated Date</th>
					<th>Terminated Reason</th>
					-->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.CITIZEN_ID }</td>
						<td>${plan.CITIZEN_NAME }</td>
						<td>${plan.GENDER }</td>
						<td>${plan.PLAN_NAME }</td>
						<td>${plan.PLAN_STATUS }</td>
						<td>${plan.PLAN_START_DATE }</td>
						<td>${plan.PLAN_END_DATE }</td>
						<td>${plan.BENEFIT_AMOUNT }</td>
						<!--  
						<td>${plan.DENIAL_REASON }</td>
						<td>${plan.TERMINATED_DATE }</td>
						<td>${plan.TERMINATION_REASON }</td>
						-->
					</tr>


				</c:forEach>
				<tr>
					<c:if test="${empty plans }">
						<td colspan="8" style="text-align: center">No results found</td>

					</c:if>
				</tr>


			</tbody>

		</table>
		<hr />

		Export : <a href="">Excel</a> <a href="">Pdf</a>


	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>