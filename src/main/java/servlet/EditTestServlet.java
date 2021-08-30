package servlet;

import database.DAO.HomeworkDAO;
import database.DAO.SubjectDAO;
import database.DAO.TestDAO;
import models.Homework;
import models.Subject;
import models.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "editTestServlet", value = "/editTestServlet")
public class EditTestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int testId = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String sMonSubjectId = request.getParameter("MonSubject");
        String sTueSubjectId = request.getParameter("TueSubject");
        String date = request.getParameter("date");
        String grade = request.getParameter("grade");
        Test t = new Test();
        t.setTestId(testId);
        Subject s = null;

        if (sMonSubjectId.equals("") && !sTueSubjectId.equals("")) {
            setTest(response, content, sTueSubjectId, date, grade,t);
        } else if (!sMonSubjectId.equals("") && sTueSubjectId.equals("")) {
            setTest(response, content, sMonSubjectId, date, grade,t);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void setTest(HttpServletResponse response, String content, String sSubjectId, String date, String sGrade ,Test t) throws IOException {
        Subject s;
        int SubjectId = Integer.parseInt(sSubjectId);
        double grade = Double.parseDouble(sGrade);
        s = new SubjectDAO().selectById(SubjectId);
        t.setContent(content);
        t.setSubjectId(s);
        t.setDate(date);
        t.setGrade(grade);
        new TestDAO().update(t);
        response.sendRedirect("tests.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}