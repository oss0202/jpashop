package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            //Order order = em.find(Order.class, 1L);
            //예제 2번 양방향 연관관계 세팅을 위해서 위 메소드 호출 주석처리
            /*Long memberId = order.getMemberId();

            // 1. find 2번 해야한다.
            Member member = em.find(Member.class, memberId);
            
            // 2. Order Class에 Member Class를 변수로 추가
            Member findMember = order.getMember();*/

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();;
    }
}
