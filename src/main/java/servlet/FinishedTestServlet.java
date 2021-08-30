package servlet;

import database.Connector;
import database.DAO.TestDAO;
import models.Test;

import javax.persistence.EntityManager;
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

        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Test t = testDAO.selectById(testId,em);
        t.setCompleted(true);

        em.getTransaction().commit();
        em.close();

        response.sendRedirect("tests.jsp?complete=true");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int testId = Integer.parseInt(request.getParameter("testId"));
        TestDAO testDAO = new TestDAO();

        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Test t = testDAO.selectById(testId,em);
        t.setCompleted(false);

        em.getTransaction().commit();
        em.close();

        response.sendRedirect("tests.jsp");
    }
}