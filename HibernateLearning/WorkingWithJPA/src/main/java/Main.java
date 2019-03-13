import com.persistance.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManager em = Persistence.
                createEntityManagerFactory("hello-world").
                createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            Message msg = new Message("Hello");
            em.persist(msg);
            transaction.commit();
        }	catch(Exception e) {
        if(transaction != null) { transaction.rollback(); }
        e.printStackTrace();
    }	finally {
        if(em != null) { em.close(); }
    }



}
}
