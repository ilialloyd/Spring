<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

Customer home page:

<br><br>
Customer is confirmed: ${customerAtt.firstName} ${customerAtt.lastName}

<br><br>
Free passes: ${customerAtt.freePasses}

<br><br>
Postal Code: ${customerAtt.postalCode}

<br><br>
Course Code: ${customerAtt.courseCode}
</body>
</html>