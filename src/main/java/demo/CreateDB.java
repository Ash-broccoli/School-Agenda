package demo;

import database.Connector;
import models.Homework;
import models.Subject;

import javax.persistence.EntityManager;

public class CreateDB {
    public static void main(String[] args) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        DBData data = new DBData();
        for (Subject s : data.getSubject()) {
            em.persist(s);
        }

        for(Homework hw : data.getHomework()){
            em.persist(hw);
        }

        em.getTransaction().commit();
        em.close();
    }
}
