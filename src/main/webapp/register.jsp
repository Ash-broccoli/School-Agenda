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
  <title>Register</title>
</head>
<body>
<div class="box">
  <h2>Register</h2>
  <form action="registerServlet" method="post">
    <div class="inputBox">
      <input type="text" name="username" autofocus required>
      <label >Username</label>
    </div>
    <div class="inputBox">
      <input type="password" name="password" id="setPassword" required>
      <label >Password</label>
    </div>
    <div class="inputBox">
      <input oninput="checkPwd()" type="password" id="password2" name="password2" required>
      <label >Confirm password</label>
    </div>
    <p style="color: red" id="warning"></p>
    <%if(session.getAttribute("wrongLogin") != null){%>
    <p style="color: red; text-align: center;">Username or password is incorrect</p>
    <%}%>
    <input type="submit" id="submit" value="Register">
  </form>
</div>
<script>
  function checkPwd() {
    let password = document.getElementById("setPassword").value;
    let password2 = document.getElementById("password2").value;

    if(password !== password2) {
      document.getElementById("warning").innerHTML="Passwords aren't identical!";
      document.getElementById("submit").disabled = true;
    }else{
      document.getElementById("warning").innerHTML="";
      document.getElementById("submit").disabled = false;
    }
  }
</script>
</body>
</html>
