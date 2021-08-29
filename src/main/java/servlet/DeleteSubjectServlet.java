package servlet;


import database.DAO.SubjectDAO;
import models.Subject;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteSubjectServlet", value = "/deleteSubjectServlet")
public class DeleteSubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int subjectId = Integer.parseInt(request.getParameter("id"));
        SubjectDAO subjectDAO = new SubjectDAO();
        Subject s = subjectDAO.selectById(subjectId);
        subjectDAO.delete(s);
        response.sendRedirect("subjects.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}