package database.DAO;

import database.Connector;
import models.Test;

import javax.persistence.EntityManager;
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
}
