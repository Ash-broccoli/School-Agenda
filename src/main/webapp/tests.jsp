<%@ page import="models.Homework" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.DAO.HomeworkDAO" %>
<%@ page import="models.Test" %>
<%@ page import="database.DAO.TestDAO" %><%--
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
    <link rel="icon" type="image/png" href="img/icon.png">
    <title>School-Agenda</title>
</head>
<body <%
    if (request.getParameter("complete") != null) {
%>
        onload="snackbarPopup()"
        <%
            }%>>
<%
    if (session.getAttribute("loginId") == null) {
        response.sendRedirect("login.jsp");
    } else {
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
                        <a class="nav-link active" aria-current="page" href="tests.jsp">Tests</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="grades.jsp">Grades</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="subjects.jsp">Subjects</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="color: red" class="nav-link" aria-current="page" href="logoutServlet">Log-out</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
    <br>
    <h1>Tests</h1>
    <div style="height: 50px">
        <button class="btn btn-Secondary" onclick="window.location.href='addTest.jsp'">Add Test</button>
    </div>
    <%
        int id = (Integer) session.getAttribute("loginId");
        TestDAO testDAO = new TestDAO();
        ArrayList<Test> incompleteTests;
        ArrayList<Test> completeTests;
        ArrayList<Test> gradedTests;
        incompleteTests = (ArrayList<Test>) testDAO.selectByLoginAndCompletion(id, false);
        completeTests = (ArrayList<Test>) testDAO.selectByLoginAndCompletion(id, true);
        gradedTests = (ArrayList<Test>) testDAO.selectByLoginAndGraded(id, true);
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
                <th scope="col">Done?</th>
                <th scope="col"></th>
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
                <td>
                    <form action="finishedTestServlet" method="get">
                        <input type=hidden name="testId" value="<%out.print(t.getTestId());%>">
                        <button type=submit
                                name="submit" class="btn btn-success">Yepp!
                        </button>
                    </form>
                </td>
                <td>
                    <button onclick="window.location='editTest.jsp?editId=<%out.print(t.getTestId());%>'"
                            class="btn btn-secondary">Edit
                    </button>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <%
        } else {
            out.print("<h3>Upcoming tests</h3>");
            out.print("<p>No test stress for you :)</p>");
        }
    %>
    <br>
    <div id="snackbar">Awesome. Edit the test and add your grade.</div>
    <hr class="pageDivider"/>
    <br>
    <div class="row">
        <%if (!completeTests.isEmpty()) {%>
        <div class="col-6">

            <h3>Written tests</h3>
            <div class="table-responsive">
                <table class="table table-Secondary table-striped table-hover">
                    <thead class="white-header">
                    <tr>
                        <th scope="col">Content</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Date</th>
                        <th scope="col">Done?</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%for (Test t : completeTests) {%>
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
                        <td>
                            <form action="finishedTestServlet" method="post">
                                <input type=hidden name="testId" value="<%out.print(t.getTestId());%>">
                                <button type=submit
                                        name="submit" class="btn btn-danger">...wait no
                                </button>
                            </form>
                        </td>
                        <td>
                            <button onclick="window.location='editTest.jsp?editId=<%out.print(t.getTestId());%>'"
                                    class="btn btn-secondary">Grade
                            </button>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
            <%
                } else {
                    out.print("<div class=\"col-6\">");
                    out.print("<h3>Completed tests</h3>");
                    out.print("<p>No completed tests? Damn...</p>");
                    out.print("</div>");
                }
            %>


        <%if (!gradedTests.isEmpty()) {%>
        <div class="col-6">

            <h3>Graded tests</h3>
            <div class="table-responsive">
                <table class="table table-Secondary table-striped table-hover">
                    <thead class="white-header">
                    <tr>
                        <th scope="col">Content</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Date</th>
                        <th scope="col">Grade</th>
                        <th scope="col">Weight</th>
                        <th scope="col">Done?</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%for (Test t : gradedTests) {%>
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
                        <td>
                            <%out.print(t.getGrade());%>
                        </td>
                        <td>
                            <% if(t.getWeight() != 0){ out.print(t.getWeight() + "%");} else{out.print("No weight");} %>
                        </td>
                        <td>
                            <form action="finishedTestServlet" method="post">
                                <input type=hidden name="testId" value="<%out.print(t.getTestId());%>">
                                <button type=submit
                                        name="submit" class="btn btn-danger">...wait no
                                </button>
                            </form>
                        </td>
                        <td>
                            <button onclick="window.location='editTest.jsp?editId=<%out.print(t.getTestId());%>'"
                                    class="btn btn-secondary">Edit
                            </button>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
            <%
                } else {
                    out.print("<div class=\"col-6\">");
                    out.print("<h3>Graded tests</h3>");
                    out.print("<p>Be sure to edit and add a grade when completed!</p>");
                    out.print("</div>");
                }
            %>

    </div>
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
<%}%>
</body>
</html>
