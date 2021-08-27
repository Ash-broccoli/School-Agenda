package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to manage Hibernate Connections
 *
 * @author Alyssa Heimlicher
 * @since 27/08/2021
 */
public class Connector {
    private static Connector instance = null;
    private EntityManagerFactory sessionFactory = null;
    private boolean autoclose = true;

    /**
     * Private Constructor to initialize the SessionFactory
     *
     * @author Andreas
     * @since 17.07.2021
     */
    private Connector() {
        sessionFactory = Persistence.createEntityManagerFactory("schoolAgenda");
    }

    /**
     * @return the Connector Instance
     * @author Andreas
     * @since 17.07.2021
     */
    public static Connector getInstance() {
        if (Connector.instance == null)
            Connector.instance = new Connector();
        return Connector.instance;
    }

    /**
     * Opens a connection to the Database
     *
     * @return an EntityManager
     * @author Andreas
     * @since 17.07.2021
     */
    public EntityManager open() {
        return sessionFactory.createEntityManager();
    }

    /**
     * @return if autoclose is activated
     * @author Marc Andri Fuchs
     * @since 17.07.2021
     */
    public boolean isAutoclose() {
        return autoclose;
    }

    /**
     * @param autoclose new boolean if autoclose is activated
     * @author Marc Andri Fuchs
     * @since 17.07.2021
     */
    public void setAutoclose(boolean autoclose) {
        this.autoclose = autoclose;
    }
}