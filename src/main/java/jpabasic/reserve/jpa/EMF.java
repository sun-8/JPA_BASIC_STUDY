package jpabasic.reserve.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// EntityManager를 쉽게 구하기 위한 클래스
public class EMF {
    private static EntityManagerFactory emf;

    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}

/* EntityManager가 제공하는 메서드
*   persist()
*   find()
*   remove()
*   merge()
* */