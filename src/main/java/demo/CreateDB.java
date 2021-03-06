package demo;

import database.Connector;
import models.Login;

import javax.persistence.EntityManager;

public class CreateDB {
    public static void main(String[] args) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        DBData data = new DBData();
        for (Login s : data.getLogin()) {
            em.persist(s);
        }

        em.getTransaction().commit();
        em.close();
    }
}
