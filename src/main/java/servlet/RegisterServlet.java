package servlet;

import database.DAO.LoginDAO;
import models.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        String username = request.getParameter("setUsername");
        String password = request.getParameter("setPassword");
        LoginDAO loginDAO = new LoginDAO();

        Login sameUsername = loginDAO.selectByUsername(username);
        if (sameUsername == null) {
            Login l = new Login();
            l.setUsername(username);
            l.setPassword(password);
            loginDAO.insert(l);

            System.out.println("username = " + username);
            System.out.println("password = " + password);
            response.sendRedirect("login.jsp");
        } else {

            session.setAttribute("userExists", 1);
            response.sendRedirect("register.jsp");
        }

    }
}