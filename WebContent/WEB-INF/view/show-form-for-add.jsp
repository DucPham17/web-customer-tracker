<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
Add Form For CM
</div>
<form:form action="processAddForm" modelAttribute="customer" method="POST">
	<form:hidden path="id"/>
	First Name: <form:input path="firstName"/>
	<br/>
	Last Name: <form:input path="lastName"/>
	<br/>
	Email:<form:input path="email"/>
	
	<button>submit</button>
</form:form>
<div>
<a href="/web-customer-tracker/customer/list">Back To List</a>
</div>
</body>
</html>