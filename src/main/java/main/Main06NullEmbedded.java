package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Grade;
import jpabasic.reserve.domain.Hotel;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main06NullEmbedded {
    private static Logger logger = LoggerFactory.getLogger(Main06NullEmbedded.class);

    public static void main(String[] args) {
        EMF.init();
        deleteHotel();
        saveHotel();
        printHotel();
        EMF.close();
    }

    private static void deleteHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H009");
            if (hotel != null) {
                logger.info("hotel already insert!!!");

                em.remove(hotel);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private static void saveHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(
                    new Hotel("H009", "HS", 2022, Grade.S7, null)
            );
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private static void printHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H009");
            if (hotel != null) {
                logger.info("주소 : {}", hotel.getAddress());
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
