<%--
  Created by IntelliJ IDEA.
  User: Alyssa Heimlicher
  Date: 30/08/2021
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="icon" type="image/png" href="img/icon.png">
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
        <%if(session.getAttribute("wrongLogIn") != null && (Integer) session.getAttribute("wrongLogIn") == 1){%>
        <p style="color: red; text-align: center;">Username or password is incorrect. Register if needed</p>
        <%
            session.setAttribute("wrongLogIn", 0);
            }
        %>
       <p style="color: white">Don't have a login? <a style="text-decoration: underline;" href="register.jsp">Register here!</a></p>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
