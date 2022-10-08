<%--
  Created by IntelliJ IDEA.
  User: ilialloyd
  Date: 10/7/2022
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="d-flex flex-column justify-content-center w-100 h-100">

  <h2> Larche Arnprior Welcome Page Page</h2>

  <hr>

  <p>
    Welcome to the Larche Landing page!  This page is open to the public ... no login required :-)
  </p>

  <hr>

  <p>
    <a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires login)</a>
  </p>


</div>

</body>
</html>
