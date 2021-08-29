package servlet;

import database.DAO.SubjectDAO;
import models.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addSubjectServlet", value = "/addSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subject = request.getParameter("subject");
        String day = request.getParameter("day");
        Subject s = new Subject();

        s.setSubject(subject);
        s.setDay(day);
        new SubjectDAO().insert(s);

        response.sendRedirect("subjects.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}