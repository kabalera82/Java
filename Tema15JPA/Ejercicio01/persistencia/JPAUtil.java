package Tema15JPA.Ejercicio01.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("AlumnoPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
