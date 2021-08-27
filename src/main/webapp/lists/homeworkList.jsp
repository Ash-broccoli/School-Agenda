<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Homework" %>
<%@ page import="database.DAO.HomeworkDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%
    ArrayList<Homework> hwList;

    hwList = (ArrayList<Homework>) new HomeworkDAO().select();

    for (Homework hw : hwList) {
%>
<table class="table table-dark table-striped table-hover">
    <thead class="white-header">
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

</table>
<%}%>
