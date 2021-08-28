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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <title>School-Agenda</title>
</head>
<body <%
    if (request.getParameter("complete") != null) {
        System.out.println("popup");
%>
        onload="snackbarPopup()"
        <%
            }%>>
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
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <h1>Homework</h1>
    <%
        System.out.println(request.getParameter("complete"));
        ArrayList<Homework> incompleteHw;
        ArrayList<Homework> completeHw;
        HomeworkDAO homeworkDAO = new HomeworkDAO();

        incompleteHw = (ArrayList<Homework>) homeworkDAO.selectByCompletion(false);
        completeHw = (ArrayList<Homework>) homeworkDAO.selectByCompletion(true);
        if (!incompleteHw.isEmpty()) {
    %>
    <h3>Uncompleted</h3>
    <div class="table-responsive">
        <table class="table table-Secondary table-striped table-hover">
            <thead class="white-header">
            <tr>
                <th scope="col">Task</th>
                <th scope="col">Subject</th>
                <th scope="col">Due until</th>
                <th scope="col">Status</th>
                <th scope="col">Done?</th>
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
                <td>
                    <form action="finishedTaskServlet" method="post">
                        <input type=hidden name="homeworkId" value="<%out.print(hw.getHomeworkId());%>">
                        <button type=submit
                                name="submit" class="btn btn-success">Yepp!
                        </button>
                    </form>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <%
        } else {
            out.println("<h3>Uncompleted</h3>");
            out.println("<br>");
            out.println("<p>Yay! Nothing to do :)");
            out.println("<br>");
        }%>
    <br>
    <div id="snackbar">I'm so proud of you! Take a small break</div>
    <hr class="pageDivider"/>
    <br>
    <%
        if (!completeHw.isEmpty()) {

    %>
    <h3>Completed</h3>
    <div class="table-responsive">
        <table style="color: black" class="table table-Secondary table-striped table-hover">
            <thead class="white-header">
            <tr>
                <th scope="col">Task</th>
                <th scope="col">Subject</th>
                <th scope="col">Was due till</th>
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
    </div>
    <%
        } else {
            out.println("<h3>Completed</h3>");
            out.println("<br>");
            out.println("<p>Complete some tasks to get it over with.");
        }
    %>

</div>
<script>
    function snackbarPopup() {
        var x = document.getElementById("snackbar");
        x.className = "show";
        setTimeout(function () {
            x.className = x.className.replace("show", "");
        }, 3000);
    }
</script>
</body>
</html>
