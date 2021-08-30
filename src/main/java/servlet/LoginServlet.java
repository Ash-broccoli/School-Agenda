package servlet;

import database.DAO.LoginDAO;
import login.SHA256;
import models.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.internal.ManagedSessionContext;

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
        String encodedPws = SHA256.getInstantSHA(password);
        boolean loggedIn = false;
        ArrayList<Login> Llist =(ArrayList<Login>) new LoginDAO().select();
        for(Login l : Llist){
            if (l.getUsername().equals(username)&&l.getPassword().equals(encodedPws)) {
                id = l.getLoginId();
                loggedIn = true;
                break;
            }
        }
        if(loggedIn){
            session.setAttribute("loginId", id);
            response.sendRedirect("index.jsp");
            System.out.println("logged in");
        }else{
            session.setAttribute("wrongLogin", 1);
            response.sendRedirect("login.jsp");
            System.out.println("no");
        }
    }
}