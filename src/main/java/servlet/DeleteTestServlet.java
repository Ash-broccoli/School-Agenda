package servlet;

import database.DAO.TestDAO;
import models.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "deleteTestServlet", value = "/deleteTestServlet")
public class DeleteTestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int testId = Integer.parseInt(request.getParameter("id"));
        new TestDAO().deleteById(testId);
        response.sendRedirect("tests.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}