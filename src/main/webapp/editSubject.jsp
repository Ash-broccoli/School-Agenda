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
    <link rel="icon" type="image/png" href="img/icon.png">
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
                        <a class="nav-link active" aria-current="page" href="subjects.jsp">Subjects</a>
                    </li>  </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="color: red" class="nav-link" aria-current="page" href="logoutServlet">Log-out</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
    <br>
    <h1>Edit Subject</h1>
    <%
        int id = Integer.parseInt(request.getParameter("editId"));
        Subject s = new SubjectDAO().selectById(id);
        String subject = s.getSubject();
        String day = s.getDay();
    %>
    <form action="editSubjectServlet" method="get" accept-charset="UTF-8">
        <div class="mb-3">
            <label for="subject">Subject</label>
            <input type="text" name="subject" id="subject" class="form-control" value="<%out.print(subject);%>" placeholder="Subject" autofocus required>
            <input type="hidden" name="id" value="<%out.print(id);%>">
        </div>
        <br>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="day" id="monday" value="Monday"
            <%if(day.equals("Monday")){%> checked<%}%>>
            <label class="form-check-label" for="monday">Monday</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="day" id="tuesday" value="Tuesday"
                <%if(day.equals("Tuesday")){%> checked<%}%>>
            <label class="form-check-label" for="tuesday">Tuesday</label>
        </div>
        <br>
        <br>
        <button class="btn btn-Secondary" type="submit" name="submit">Edit</button>
    </form>
    <div>
        <button class="btn btn-Secondary" onclick="window.history.back()">Back</button>
        <button class="btn btn-danger" onclick="window.location='deleteSubjectServlet?id=<%out.print(id);%>'">Delete Subject</button>
    </div>
</div>
</body>
</html>
