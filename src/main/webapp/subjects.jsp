<%@ page import="models.Homework" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.DAO.HomeworkDAO" %>
<%@ page import="models.Subject" %>
<%@ page import="database.DAO.SubjectDAO" %><%--
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
                        <a class="nav-link active" aria-current="page" href="subjects.jsp">Subjects</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <h1>Subjects</h1>
    <%
        ArrayList<Subject> subListMon;
        ArrayList<Subject> subListTue;
        SubjectDAO subjectDAO = new SubjectDAO();
        subListMon = (ArrayList<Subject>) subjectDAO.selectByDay("Monday");
        subListTue = (ArrayList<Subject>) subjectDAO.selectByDay("Tuesday");
    %>
    <br>
    <div class="row">
        <div class="col">
            <h3>Monday</h3>
            <table class="table table-Secondary table-striped table-hover">
                <thead class="white-header">
                <tr>
                    <th scope="col">Subject</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <% for (Subject s : subListMon) {%>
                <tr>
                    <td>
                        <%out.print(s.getSubject());%>
                    </td>
                    <td>
                        <form action="finishedTaskServlet" method="post">
                            <input type=hidden name="subjectId" value="<%out.print(s.getSubjectId());%>">
                            <button type=submit
                                    name="submit" class="btn btn-secondary">Edit
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>

        <div class="col">
            <h3>Tuesday</h3>
            <table class="table table-Secondary table-striped table-hover">
                <thead class="white-header">
                <tr>
                    <th scope="col">Subject</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <% for (Subject s : subListTue) {%>
                <tr>
                    <td>
                        <%out.print(s.getSubject());%>
                    </td>
                    <td>
                        <form action="finishedTaskServlet" method="post">
                            <input type=hidden name="subjectId" value="<%out.print(s.getSubjectId());%>">
                            <button type=submit
                                    name="submit" class="btn btn-secondary">Edit
                            </button>
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
