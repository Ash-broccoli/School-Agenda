package database.DAO;

import database.Connector;
import models.Homework;
import models.Login;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class LoginDAO {
    public void insert(Login l) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
    }

    public List<Login> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        List<Login> result = em.createQuery("select l from Login l", Login.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Login selectById(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Login result = selectById(id, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Login selectById(int id, EntityManager em) {
        try {
            return em.createQuery("select l from Login l where l.loginId = :id", Login.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
