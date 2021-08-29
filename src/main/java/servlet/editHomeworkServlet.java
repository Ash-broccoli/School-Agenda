package servlet;

import database.DAO.HomeworkDAO;
import database.DAO.SubjectDAO;
import models.Homework;
import models.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editHomeworkServlet", value = "/editHomeworkServlet")
public class editHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int homeworkId = Integer.parseInt(request.getParameter("id"));
        String task = request.getParameter("task");
        String sMonSubjectId = request.getParameter("MonSubject");
        String sTueSubjectId = request.getParameter("TueSubject");
        String dueDate = request.getParameter("due");
        Homework hw = new Homework();
        hw.setHomeworkId(homeworkId);
        Subject s = null;

        if (sMonSubjectId.equals("") && !sTueSubjectId.equals("")) {
            setHomework(response, task, sTueSubjectId, dueDate, hw);
        } else if (!sMonSubjectId.equals("") && sTueSubjectId.equals("")) {
            setHomework(response, task, sMonSubjectId, dueDate, hw);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
        private void setHomework(HttpServletResponse response, String task, String sSubjectId, String dueDate, Homework hw) throws IOException {
            Subject s;
            int SubjectId = Integer.parseInt(sSubjectId);
            s = new SubjectDAO().selectById(SubjectId);
            hw.setHomework(task);
            hw.setSubjectId(s);
            hw.setDueTill(dueDate);
            new HomeworkDAO().update(hw);
            response.sendRedirect("homework.jsp");
        }


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}