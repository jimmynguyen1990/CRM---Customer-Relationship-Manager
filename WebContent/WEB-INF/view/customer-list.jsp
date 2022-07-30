<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Customer List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<br></br>

	<input type="submit" value="Add Customer"
		onclick="window.location.href='showAddingForm';return false;"
		class="add-button" />
		
	<form:form action="searchCustomer" method="POST">
		<input type="submit" value="Search Customer" class="add-button"/>
		<input type="text" name="theSearchName"/>
	</form:form>		

	<div id="container">
		<div id="content">

			<!-- Print out html -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- Loop over the customer list -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- Construct an update link with customer id -->
					<c:url var="updateLink" value="/customer/showUpdateForm">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<!-- Construct a delete link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						
						<!-- display the update link -->
						<td>
							<a href="${updateLink}">Update</a>|
							<a href="${deleteLink}" 
							 onclick="if(!(confirm('Are your sure to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>

</body>
</html>