package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editHomeworkServlet", value = "/editHomeworkServlet")
public class editHomeworkServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}