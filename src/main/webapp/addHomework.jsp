<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Subject" %>
<%@ page import="database.DAO.SubjectDAO" %><%--
  Created by IntelliJ IDEA.
  User: alyss
  Date: 29/08/2021
  Time: 03:30
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
                        <a class="nav-link active" aria-current="page" href="homework.jsp">Homework</a>
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
    <h1>Add Homework</h1>
    <form action="addHomeworkServlet" method="get" accept-charset="UTF-8">
        <div class="mb-3">
            <label for="task">Task</label>
            <input type="text" name="task" id="task" class="form-control" placeholder="Task" autofocus required>
        </div>
        <br>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="MonSubject">Monday subjects</label>
                <select id="MonSubject" class="form-control" name="MonSubject">
                    <option selected value="">Select one</option>
                    <%
                        ArrayList<Subject> MonSubList = (ArrayList<Subject>) new SubjectDAO().selectByDay("Monday");
                        for (Subject sub : MonSubList) {
                    %>
                    <option class="form-control" value="<%out.print(sub.getSubjectId());%>"><%
                        out.print(sub.getSubject());%></option>
                    <%}%>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="TueSubject">Tuesday subjects</label>
                <select id="TueSubject" class="form-control" name="TueSubject">
                    <option selected value="">Select one </option>
                    <%
                        ArrayList<Subject> TueSubList = (ArrayList<Subject>) new SubjectDAO().selectByDay("Tuesday");
                        for (Subject sub : TueSubList) {
                    %>
                    <option class="form-control" value="<%out.print(sub.getSubjectId());%>"><%
                        out.print(sub.getSubject());%></option>
                    <%}%>
                </select>
            </div>
        </div>
        <br>
        <div class="mb-3">
            <label for="due">Due date</label>
            <input type="date" name="due" id="due" class="form-control" placeholder="Due date" required>
        </div>
        <br>
        <button class="btn btn-Secondary" type="submit" name="submit">Add homework</button>
    </form>
</div>
</body>
</html>
