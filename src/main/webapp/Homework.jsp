<%@ page import="models.Homework" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.DAO.HomeworkDAO" %><%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 27/08/2021
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>School-Agenda</title>
</head>
<body>
<h1>Homework</h1>
<%
    ArrayList<Homework> hwList;

    hwList = (ArrayList<Homework>) new HomeworkDAO().select();

    for (Homework hw : hwList) {
%>
<h2>Uncompleted</h2>
<table class="table table-dark table-striped table-hover">
    <thead class="white-header">
    <tr>
        <th scope="col">Homework</th>
        <th scope="col"> </th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

</table>
<%}%>
</body>
</html>
