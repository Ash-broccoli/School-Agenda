<%@ page import="models.Homework" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.DAO.HomeworkDAO" %>
<%@ page import="database.DAO.TestDAO" %>
<%@ page import="models.Test" %><%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 27/08/2021
  Time: 17:26
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="homework.jsp">Homework</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="tests.jsp">Tests</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="grades.jsp">Grades</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="subjects.jsp">Subjects</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <h1>Welcome to your Agenda</h1>
    <%
        TestDAO testDAO = new TestDAO();
        ArrayList<Test> incompleteTests;
        incompleteTests = (ArrayList<Test>) testDAO.selectByCompletion(false);
        if (!incompleteTests.isEmpty()) {
    %>
    <h3>Upcoming tests</h3>
    <div class="table-responsive">
        <table class="table table-Secondary table-striped table-hover">
            <thead class="white-header">
            <tr>
                <th scope="col">Content</th>
                <th scope="col">Subject</th>
                <th scope="col">Date</th>
            </tr>
            </thead>
            <tbody>
            <%for (Test t : incompleteTests) {%>
            <tr>
                <td>
                    <%out.print(t.getContent());%>
                </td>
                <td>
                    <%out.print(t.getSubjectId().getSubject());%>
                </td>
                <td>
                    <%out.print(t.getDate());%>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <%
        } else {
            out.print("<h3>Upcoming tests</h3>");
            out.print("<p>No upcoming tests</p>");
        }
    %>
    <hr class="pageDivider"/>
    <%
        ArrayList<Homework> incompleteHw;
        HomeworkDAO homeworkDAO = new HomeworkDAO();

        incompleteHw = (ArrayList<Homework>) homeworkDAO.selectByCompletion(false);
        if (!incompleteHw.isEmpty()) {
    %>
    <br>
    <h3>Incompleted Homework</h3>
    <div class="table-responsive">
        <table class="table table-Secondary table-striped table-hover">
            <thead class="white-header">
            <tr>
                <th scope="col">Task</th>
                <th scope="col">Subject</th>
                <th scope="col">Due until</th>
                <th scope="col">Status</th>
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
    </div>
    <%
        } else {
            out.println("<h3>No incomplete homework to do</h3>");
        }%>
    <br>

</div>
</body>
</html>
