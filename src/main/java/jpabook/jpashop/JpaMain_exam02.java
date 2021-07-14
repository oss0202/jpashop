package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_exam02 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Order order = new Order();
            
            // 1안
            order.addOrderItem(new OrderItem());
                
            // 2안
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        em.close();
        emf.close();;
    }
}
