package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addHomeworkServlet", value = "/addHomeworkServlet")
public class addHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}