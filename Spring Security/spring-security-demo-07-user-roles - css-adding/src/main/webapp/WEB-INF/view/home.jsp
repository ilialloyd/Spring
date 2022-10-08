<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--Spring security taglib--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Welcome to Larche Arnprior Home Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="d-flex flex-column justify-content-center w-100 h-100">
     <h2>Personal Page</h2>
     <hr>
     <p>Welcome to the Home Page
     </p>
     <hr>
<%--     Display user name and role
     1. Import security taglib
     2. Add the username and role(authorities)

     OUTPUT:
     User: thomas
     Role(s): [ROLE_ADMIN]
     https://stackoverflow.com/questions/19525380/difference-between-role-and-grantedauthority-in-spring-security
     https://www.baeldung.com/spring-security-granted-authority-vs-role
     --%>
     User: <security:authentication property="principal.username" />
     <br><br>
     Role(s): <security:authentication property="principal.authorities" />
     <hr>

     <!-- Add a link to point to /leaders ... this is for the managers-->
<security:authorize access="hasRole('MANAGER')"> <!-- this tag show content only for the described role-->
    <p>
        <a href="${pageContext.request.contextPath}/leaders"> Leadership Meeting</a>
        (Only for Leadership peeps)
    </p>
</security:authorize>

     <!-- Add a link to point to /systems ... this is for the admins-->
<security:authorize access="hasRole('ADMIN')">
     <p>
         <a href="${pageContext.request.contextPath}/systems"> IT Systems Meeting</a>
         (Only for Admin peeps)
     </p>
</security:authorize>


     <!-- Add a logout Button function-->
     <form:form action="${pageContext.request.contextPath}/logout"
                method="POST">
         <!--adding  button itself -->
         <input type="submit" value="Logout">
     </form:form>

</div>
</body>
</html>
