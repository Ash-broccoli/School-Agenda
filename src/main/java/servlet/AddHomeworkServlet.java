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

@WebServlet(name = "addHomeworkServlet", value = "/addHomeworkServlet")
public class AddHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String task = request.getParameter("task");
        String sMonSubjectId = request.getParameter("MonSubject");
        String sTueSubjectId = request.getParameter("TueSubject");
        String dueDate = request.getParameter("due");
        Homework hw = new Homework();
        Subject s = null;

        if(sMonSubjectId.equals("") && !sTueSubjectId.equals("")){
            int tueSubjectId = Integer.parseInt(sTueSubjectId);
            s = new SubjectDAO().selectById(tueSubjectId);
        }else if(!sMonSubjectId.equals("") && sTueSubjectId.equals("")){
            int monSubjectId = Integer.parseInt(sMonSubjectId);
            s = new SubjectDAO().selectById(monSubjectId);
        }else{
            System.out.println("None");
        }
        hw.setHomework(task);
        hw.setSubjectId(s);
        hw.setDueTill(dueDate);
        hw.setCompleted(false);
        new HomeworkDAO().insert(hw);
        response.sendRedirect("homework.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}