package database.DAO;

import database.Connector;
import models.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class TestDAO {
    public void insert(Test t) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    public List<Test> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Test> result = em.createQuery("select t from Test t", Test.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List selectGrade(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List result = em.createQuery("select t.grade from Test t").getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List selectGradeFromSubject(String subject){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List result = em.createQuery("select t.grade from Test t where t.subjectId.subject = :subject").setParameter("subject", subject).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List<Test> selectByLoginAndCompletion(int loginId,boolean isComplete){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Test> result = em.createQuery("select t from Test t where t.loginId.loginId = :loginId and t.completed = :isComplete", Test.class).setParameter("loginId", loginId).setParameter("isComplete", isComplete).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Test selectById(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Test result = selectById(id, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Test selectById(int id, EntityManager em) {
        try {
            return em.createQuery("select t from Test t where t.testId = :id", Test.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void update(Test t) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Test tDB = selectById(t.getTestId(), em);
        if (tDB != null) {
            tDB.setEverything(t);
            System.out.println("Completed Test");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(int id) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Test result = selectById(id, em);
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }
}
