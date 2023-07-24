package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class NewUserService {

    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
