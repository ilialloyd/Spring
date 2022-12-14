<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<br><br>

<form:form action="processForm" modelAttribute="customerAtt">

    First name(*): <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>

    Last name: <form:input path="lastName"/>

    <br> <br>
       <!-- freePasses entry-->
    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>

    <br><br>

     Postal Code: <form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error"/>

	<br><br>


    Course Code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>

    <br><br>
    <input type="submit" value="Submit"/>

</form:form>

</body>
</html>