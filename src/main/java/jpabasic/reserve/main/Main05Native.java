package jpabasic.reserve.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Review;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main05Native {
    private static Logger logger = LoggerFactory.getLogger(Main05Native.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Review review = new Review("H-01", 5, "작성자", "댓글");
            logger.info("persist 실행 전");
            em.persist(review);
            logger.info("persist 실행 함");
            logger.info("생성한 식별자: {}", review.getId());
            logger.info("커밋하기 전");
            tx.commit();
            logger.info("커밋 함");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        EMF.close();
    }
}
