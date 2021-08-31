package database.DAO;

import database.Connector;
import models.Login;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class LoginDAO {
    public void insert(Login login, EntityManager em) {
        em.persist(login);
    }

    public void insert(Login l) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
    }

    public List<Login> select() {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        List<Login> result = em.createQuery("select d from Login d", Login.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Login selectByUsername(String username) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Login result = selectByUsername(username, em);

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Login selectByUsername(String username, EntityManager em) {
        try {
            return em.createQuery("select l from Login l where lower(l.username) = lower(:username)", Login.class).setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Login selectById(int loginId) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Login result = em.createQuery("select l from Login l where l.loginId = :loginId", Login.class).setParameter("loginId", loginId).getSingleResult();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Login selectLoginById(int id, EntityManager em) {
        try {
            return em.createQuery("select l from Login l where l.loginId = :id", Login.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void update(Login l) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Login loginDB = selectLoginById(l.getLoginId(), em);
        if (loginDB != null) {
            loginDB.setPassword(l.getPassword(), false);
        }
        em.getTransaction().commit();
        em.close();

    }

}
