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

@WebServlet(name = "deleteHomeworkServlet", value = "/deleteHomeworkServlet")
public class DeleteHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int homeworkId = Integer.parseInt(request.getParameter("id"));
        System.out.println("homeworkId = " + homeworkId);
        HomeworkDAO homeworkDAO = new HomeworkDAO();
        Homework hw = homeworkDAO.selectById(homeworkId);
        homeworkDAO.delete(hw);
        response.sendRedirect("homework.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}