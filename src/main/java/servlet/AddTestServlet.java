package servlet;

import database.DAO.SubjectDAO;
import database.DAO.TestDAO;
import models.Subject;
import models.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "addTestServlet", value = "/addTestServlet")
public class AddTestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = request.getParameter("content");
        String sMonSubjectId = request.getParameter("MonSubject");
        String sTueSubjectId = request.getParameter("TueSubject");
        String date = request.getParameter("date");
        Test t = new Test();

        if (sMonSubjectId.equals("") && !sTueSubjectId.equals("")) {
            setTest(response, content, sTueSubjectId, date,t);
        } else if (!sMonSubjectId.equals("") && sTueSubjectId.equals("")) {
            setTest(response, content, sMonSubjectId, date ,t);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void setTest(HttpServletResponse response, String content, String sSubjectId, String date,Test t) throws IOException {
        Subject s;
        int SubjectId = Integer.parseInt(sSubjectId);
        s = new SubjectDAO().selectById(SubjectId);
        t.setContent(content);
        t.setSubjectId(s);
        t.setDate(date);
        t.setGrade(0.0);
        new TestDAO().insert(t);
        response.sendRedirect("tests.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}