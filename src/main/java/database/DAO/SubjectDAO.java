package database.DAO;

import database.Connector;
import models.Homework;
import models.Subject;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class SubjectDAO {
    public void insert(Subject s) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Subject s) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.remove(em.contains(s) ? s : em.merge(s));
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

    public List<Subject> selectByLoginAndDay(int loginId,String day){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Subject> result = em.createQuery("select s from Subject s where s.loginId.loginId = :loginId and s.day = :day", Subject.class).setParameter("loginId", loginId).setParameter("day", day).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Subject selectById(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Subject result = selectById(id, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Subject selectById(int id, EntityManager em) {
        try {
            return em.createQuery("select s from Subject s where s.subjectId = :id", Subject.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void update(Subject s) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Subject hwDB = selectById(s.getSubjectId(), em);
        if (hwDB != null) {
            hwDB.setEverything(s);
        }
        em.getTransaction().commit();
        em.close();
    }
}
