<%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 29/08/2021
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <title>School-Agenda</title>
</head>
<body>
<%
    if (session.getAttribute("loginId") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="container">
    <br>
    <h1>Error something in the form was invalid!!</h1>
    <br>
    <h2>Click <a style="text-decoration: underline; cursor: pointer" onclick="window.history.back()">here</a> to go back</h2>
</div>
</body>
</html>
