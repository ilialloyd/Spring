<%--Bu sehifeni elave edib  esas yere link qoyuruq. bir nov landing page olur bu--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h3>Spring Rest Demo</h3>
<hr>
<%--əgər testden qabaq . slash qoysam onda contextpath vermeliyem ekss halıda ehtiyac yoxdu
 contextpath ucun jsp-api de mavenle yuklemeyim lazimdir--%>
<%--<a href="test/hello">Hello</a>--%>
<a href="${pageContext.request.contextPath}/test/hello">Hello World</a>
<hr>
<a href="api/student">To see Student's List</a>
</body>
</html>
