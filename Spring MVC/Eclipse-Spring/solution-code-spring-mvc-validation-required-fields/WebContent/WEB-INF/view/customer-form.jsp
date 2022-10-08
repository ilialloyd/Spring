<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Customer Register Form</title>

<!-- error massage css design -->

<style>
.error {
	color: red
}
</style>

</head>


<body>

	<i>Fill out the form. Asteriks(*) means required</i>

	<br>
	<br>

	<form:form action="processForm" modelAttribute="customer">

First name(*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>

Last name:     <form:input path="lastName" />

		<br>
		<br>
		<!-- if there is error, set the error -->


		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>