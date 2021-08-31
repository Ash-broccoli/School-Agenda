package servlet;

import database.DAO.LoginDAO;
import database.DAO.SubjectDAO;
import models.Login;
import models.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addSubjectServlet", value = "/addSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int loginId = (Integer) session.getAttribute("loginId");
        Login l = new LoginDAO().selectById(loginId);
        String subject = request.getParameter("subject");
        String day = request.getParameter("day");
        Subject s = new Subject();

        s.setSubject(subject);
        s.setDay(day);
        s.setLoginId(l);
        new SubjectDAO().insert(s);

        response.sendRedirect("subjects.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}