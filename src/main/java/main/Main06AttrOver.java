package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.common.Address;
import jpabasic.employee.domain.Employee;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main06AttrOver {
    private static Logger logger = LoggerFactory.getLogger(Main06AttrOver.class);

    public static void main(String[] args) {
        EMF.init();
        saveEmployee();
        EMF.close();
    }

    private static void saveEmployee() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Address home = new Address("집주소1", "집주소2", "12345");
            Address work = new Address("직장주소1", "직장주소2", "09876");
            Employee employee = new Employee("EMP01", home, work);
            em.persist(employee);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
