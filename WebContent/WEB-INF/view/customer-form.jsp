<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Customer Form</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<h3>Save Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST">
		
		<!-- Send back customer with current id -->
		<form:hidden path="id"/>

		<table>
			<tbody>
				<tr>
					<td><label>First Name</label>
					<td><form:input path="firstName"/></td>
				</tr>
				
				<tr>
					<td><label>Last Name</label>
					<td><form:input path="lastName"/></td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>

			</tbody>

		</table>


	</form:form>

<br></br>

<div style="clear; both;">
<a href="${pageContext.request.contextPath}/customer/list">Back To Customer List</a>
</div>


</body>
</html>