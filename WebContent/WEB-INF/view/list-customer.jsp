<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRS Main Page</title>
</head>
<body>
<div id=wapper>
<h1>CM: Customer Management</h1>
</div>
<div id="container">
	<div id = content>
	<button value="Add Customer" onclick="window.location.href='showFromForAdd'; return false;">Add Customer</button>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Option</th>
		</tr>
		<c:forEach var="tempCustomer" items="${customers}">
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>
			<tr>
				<td> ${tempCustomer.firstName} </td>
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
				<td> <a href="${updateLink}">Update</a> <a href="${deleteLink}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>