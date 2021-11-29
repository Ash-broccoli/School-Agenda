package servlet;

import database.Connector;
import database.DAO.SubjectDAO;
import models.Subject;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ArchiveSubjectServlet", value = "/ArchiveSubjectServlet")
public class ArchiveSubjectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        String archive = request.getParameter("archive");
        SubjectDAO subjectDAO = new SubjectDAO();

        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Subject s = subjectDAO.selectById(subjectId,em);
        s.setArchived(archive.equals("true"));

        em.getTransaction().commit();
        em.close();

        response.sendRedirect("subjects.jsp");
    }
}