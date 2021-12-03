<%@ page import="models.Homework" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.DAO.HomeworkDAO" %>
<%@ page import="models.Test" %>
<%@ page import="database.DAO.TestDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="database.DAO.SubjectDAO" %>
<%@ page import="static java.lang.Double.isNaN" %>
<%@ page import="java.text.DecimalFormat" %><%--
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
    } else {
        int id = (Integer) session.getAttribute("loginId");

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
                        <a class="nav-link active" aria-current="page" href="grades.jsp">Grades</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="subjects.jsp">Subjects</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: red" class="nav-link" aria-current="page" href="logoutServlet">Log-out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <h1>Grades</h1>
    <br>
    <br>
    <div class="row">
        <%
            List<String> subjects = new SubjectDAO().selectSubject(id);
            for (String s : subjects) {
        %>
        <div class="col-3">
            <p><%out.print(s);%></p>
            <div class="table-responsive">
                <table class="table table-Secondary table-striped table-hover">
                    <thead class="white-header">
                    <tr>
                        <th scope="col">Test</th>
                        <th scope="col">Grade</th>
                        <th scope="col">Weight</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        double grade = 0;
                        List<Test> grades = new TestDAO().selectBySubject(s, id);
                        for (Test g : grades) {
                            grade += g.getGrade();
                    %>
                    <tr>
                        <td>
                            <% out.print(g.getContent()); %>
                        </td>
                        <td>
                            <% out.print(g.getGrade()); %>
                        </td>
                        <td>
                            <% out.print((g.getWeight() != 0) ? g.getWeight()+"%" : "No Weight");%>
                        </td>
                    </tr>
                    <% }

                        double avg;
                        avg = (grade / grades.size());
                        if (isNaN(avg)) {
                            avg = 0.0;
                        }
                        avg = Math.round(avg*20.0)/20.0;

                    %>

                    <tr style="border-top: 2px solid black">
                        <td style="font-weight: bold">
                            Average
                        </td>
                        <td style="text-decoration: underline">
                            <% out.print(avg); %>
                        </td>
                        <td>

                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%}%>
</body>
</html>
