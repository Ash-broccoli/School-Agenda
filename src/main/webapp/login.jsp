<%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 30/08/2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="css/login.css">
    <title>Login</title>
</head>
<body>
<div class="box">
    <h2>Login</h2>
    <form action="loginServlet" method="post">
        <div class="inputBox">
            <input type="text" name="username" autofocus required>
            <label >Username</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required>
            <label >Password</label>
        </div>
        <%if(session.getAttribute("wrongLogin") != null){%>
        <p style="color: red; text-align: center;">Username or password is incorrect</p>
        <%}%>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
