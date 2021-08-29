package servlet;


import database.DAO.SubjectDAO;
import models.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editSubjectServlet", value = "/editSubjectServlet")
public class EditSubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String subject = request.getParameter("subject");
        String day = request.getParameter("day");
        Subject s = new Subject();

        s.setSubjectId(id);
        s.setSubject(subject);
        s.setDay(day);
        new SubjectDAO().update(s);
        response.sendRedirect("subjects.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}