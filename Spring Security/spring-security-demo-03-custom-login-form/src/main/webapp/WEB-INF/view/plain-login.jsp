<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Login Page</title>
<%--    css style for error message--%>
    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>
<h3>My Custom Login Page</h3>

       <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

           <!-- Check for login error with jstl lib-->

           <c:if test="${param.error != null}">
               <i class ="failed">Sorry! You  entered invalid username/password</i>
           </c:if>

<%--You should keep password and username like below, in this case SPring will read them automatically--%>
           <p>
               User name: <input type="text" name="username">
           </p>
           <p>
               Password:   <input type="password" name="password">
           </p>

           <input type="submit" value="Login"/>
       </form:form>
</body>
</html>
