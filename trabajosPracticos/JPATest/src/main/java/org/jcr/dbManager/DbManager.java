package org.jcr.dbManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class DbManager {
    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManager == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("JPATest");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public void insert(Object object){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        System.out.println(object.toString() + " agregado a la DB");
    }
    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
    public <T> T searchById(Class<T> entityClass, Object id) {
        return entityManager.find(entityClass, id);
    }

}
