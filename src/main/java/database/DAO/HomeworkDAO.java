package database.DAO;

import database.Connector;
import models.Homework;
import models.Subject;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class HomeworkDAO {
    public void insert(Homework h) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
        em.close();
    }

    public List<Homework> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Homework> result = em.createQuery("select h from Homework h", Homework.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List<Homework> selectByCompletion(boolean isComplete){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Homework> result = em.createQuery("select h from Homework h where h.completed = :isComplete", Homework.class).setParameter("isComplete", isComplete).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Homework selectById(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Homework result = selectById(id, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Homework selectById(int id, EntityManager em) {
        try {
            return em.createQuery("select h from Homework h where h.homeworkId = :id", Homework.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void update(Homework h) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Homework hwDB = selectById(h.getHomeworkId(), em);
        if (hwDB != null) {
            hwDB.setEverything(h);
            System.out.println("Completed homework");
        }
        em.getTransaction().commit();
        em.close();
    }
}
