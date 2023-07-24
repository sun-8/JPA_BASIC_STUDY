package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = new User("user@user.com", "user", LocalDateTime.now());
            entityManager.persist(user); // DB 저장
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();

        } finally {
            entityManager.close();
        }

        emf.close();
    }
}