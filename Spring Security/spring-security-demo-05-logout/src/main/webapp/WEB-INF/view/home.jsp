<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Welcome to Ilialloyd's Dev Page</title>
</head>
<body>

     <h2>Personal Portfolio</h2>
     <hr>
     <p>Welcome to the home page
     </p>

     <!-- Add a logout Button -->
     <form:form action="${pageContext.request.contextPath}/logout"
                method="POST">
         <!--adding real button -->
         <input type="submit" value="Logout">
     </form:form>


</body>
</html>
