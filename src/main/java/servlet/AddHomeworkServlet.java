package servlet;

import com.fasterxml.jackson.databind.DatabindContext;
import database.DAO.HomeworkDAO;
import database.DAO.LoginDAO;
import database.DAO.SubjectDAO;
import models.Homework;
import models.Login;
import models.Subject;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addHomeworkServlet", value = "/addHomeworkServlet")
public class AddHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int loginId = (Integer) session.getAttribute("loginId");
        String task = request.getParameter("task");
        String sMonSubjectId = request.getParameter("MonSubject");
        String sTueSubjectId = request.getParameter("TueSubject");
        String dueDate = request.getParameter("due");
        Homework hw = new Homework();
        Subject s = null;

        if(sMonSubjectId.equals("") && !sTueSubjectId.equals("")){
            setHomework(response, task, sTueSubjectId, dueDate, loginId,hw);
        }else if(!sMonSubjectId.equals("") && sTueSubjectId.equals("")){
            setHomework(response, task, sMonSubjectId, dueDate, loginId,hw);
        }else{
            response.sendRedirect("error.jsp");
        }

    }

    private void setHomework(HttpServletResponse response, String task, String SubjectId, String dueDate, int loginId,Homework hw) throws IOException {
        Subject s;
        Login l = new LoginDAO().selectById(loginId);
        int tueSubjectId = Integer.parseInt(SubjectId);
        s = new SubjectDAO().selectById(tueSubjectId);
        hw.setHomework(task);
        hw.setSubjectId(s);
        hw.setDueTill(dueDate);
        hw.setLoginId(l);
        hw.setCompleted(false);
        new HomeworkDAO().insert(hw);
        response.sendRedirect("homework.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}