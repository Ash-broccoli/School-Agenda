package database.DAO;

import database.Connector;
import models.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class SubjectDAO {
    public void insert(Subject s) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    public List<Subject> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Subject> result = em.createQuery("select s from Subject s", Subject.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List<Subject> selectByDay(String day){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Subject> result = em.createQuery("select s from Subject s where s.day = :day", Subject.class).setParameter("day", day).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Subject selectById(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Subject result = em.createQuery("select s from Subject s where s.subjectId = :id", Subject.class).setParameter("id", id).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return result;
    }
}
