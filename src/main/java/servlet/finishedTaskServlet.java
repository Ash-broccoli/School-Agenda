package servlet;

import database.DAO.HomeworkDAO;
import models.Homework;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "finishedTaskServlet", value = "/finishedTaskServlet")
public class finishedTaskServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int homeworkId = Integer.parseInt(req.getParameter("homeworkId"));
        HomeworkDAO homeworkDAO = new HomeworkDAO();

        Homework hw = homeworkDAO.selectById(homeworkId);
        hw.setCompleted(false);
        homeworkDAO.update(hw);

        resp.sendRedirect("homework.jsp");

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int homeworkId = Integer.parseInt(req.getParameter("homeworkId"));
        HomeworkDAO homeworkDAO = new HomeworkDAO();

        Homework hw = homeworkDAO.selectById(homeworkId);
        hw.setCompleted(true);
        homeworkDAO.update(hw);

        resp.sendRedirect("homework.jsp?complete=true");

    }

    public void destroy() {
    }
}