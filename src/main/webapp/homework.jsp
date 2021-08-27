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
<div class="container">
    <h1>Homework</h1>
    <%
        ArrayList<Homework> incompleteHw;
        ArrayList<Homework> completeHw;

        incompleteHw = (ArrayList<Homework>) new HomeworkDAO().selectByCompletion(false);
        completeHw = (ArrayList<Homework>) new HomeworkDAO().selectByCompletion(true);
        if (!incompleteHw.isEmpty()) {
    %>
    <h2>Uncompleted</h2>
    <table class="table table-dark table-striped table-hover">
        <thead class="white-header">
        <tr>
            <th scope="col">Task</th>
            <th scope="col">Subject</th>
            <th scope="col">Due until</th>
            <th scope="col">Completed</th>
        </tr>
        </thead>
        <tbody>
        <% for (Homework hw : incompleteHw) {%>
        <tr>
            <td>
                <%out.print(hw.getHomework());%>
            </td>

            <td>
                <%out.print(hw.getSubjectId().getSubject());%>
            </td>

            <td>
                <%out.print(hw.getDueTill());%>
            </td>

            <td>
                <%
                    out.print("<p style=\"color: red;\">Incomplete</p>");
                %>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%
        }
        if(!completeHw.isEmpty()){

    %>
    <h2>Completed</h2>
    <table class="table table-dark table-striped table-hover">
        <thead class="white-header">
        <tr>
            <th scope="col">Task</th>
            <th scope="col">Subject</th>
            <th scope="col">Due until</th>
            <th scope="col">Completed</th>
        </tr>
        </thead>
        <tbody>
        <% for (Homework hw : completeHw) {%>
        <tr>
            <td>
                <%out.print(hw.getHomework());%>
            </td>

            <td>
                <%out.print(hw.getSubjectId().getSubject());%>
            </td>

            <td>
                <%out.print(hw.getDueTill());%>
            </td>

            <td>
                <%
                    out.print("<p style=\"color: green;\">Completed</p>");
                %>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>

</div>
</body>
</html>
