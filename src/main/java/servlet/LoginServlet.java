package servlet;

import database.DAO.LoginDAO;
import login.SHA256;
import models.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        int id = 0;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String encodedPassword = SHA256.getInstantSHA(password);
        boolean loggedIn = false;
        boolean wrongUsername = true;
        ArrayList<Login> usernames = (ArrayList<Login>) new LoginDAO().select();
        for (Login u : usernames) {
            if (username.equals(u.getUsername())) {
                id = u.getLoginId();
                wrongUsername = false;
            }
        }
        if (!wrongUsername) {
            if (encodedPassword.equals(new LoginDAO().selectById(id).getPassword())) {
                System.out.println("Logged in");
                response.sendRedirect("index.jsp");
                loggedIn = true;
                session.setAttribute("loginId", id);
            }
        }
        if (!loggedIn) {
            session.setAttribute("wrongLogIn", 1);
            response.sendRedirect("login.jsp");
        }
    }
}