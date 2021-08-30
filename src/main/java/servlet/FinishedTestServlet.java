package servlet;

import database.DAO.HomeworkDAO;
import database.DAO.TestDAO;
import models.Homework;
import models.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "finishedTestServlet", value = "/finishedTestServlet")
public class FinishedTestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));
        TestDAO testDAO = new TestDAO();

        Test t = testDAO.selectById(testId);
        t.setCompleted(true);
        testDAO.update(t);

        response.sendRedirect("tests.jsp?complete=true");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));
        TestDAO testDAO = new TestDAO();

        Test t = testDAO.selectById(testId);
        t.setCompleted(false);
        testDAO.update(t);

        response.sendRedirect("tests.jsp");
    }
}