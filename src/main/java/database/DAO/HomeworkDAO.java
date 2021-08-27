package database.DAO;

import database.Connector;
import models.Homework;

import javax.persistence.EntityManager;

public class HomeworkDAO {
    public void insert(Homework h) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
        em.close();
    }
}
