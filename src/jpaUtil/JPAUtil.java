package jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "appUnitPU";
    private static ThreadLocal<EntityManager> threadLocal;
    private static EntityManagerFactory factory;

    /**
     * Bloco estatico, inicializa na instancia da classe, carregando a unidade
     * de persistencia.
     */
    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        threadLocal = new ThreadLocal<EntityManager>();
    }

    /**
     * Metodo que retorna uma EntityManager.
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        if (threadLocal.get() == null) {
            threadLocal.set(factory.createEntityManager());
        }
        return threadLocal.get();
    }

    /**
     * Responsavel por fechar a EntityManager.
     */
    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        if (em != null) {
            threadLocal.remove();
            em.close();
        }
    }
}