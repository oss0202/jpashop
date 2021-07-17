package jpabookOneToMany.jpashop;

import jpabookOneToMany.jpashop.domain.Member;
import jpabookOneToMany.jpashop.domain.Team;

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
            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("TeamA");
            // Team 테이블이 아니라 Member 테이블에 있다.
            // 그래서 Member 테이블에 업데이트가 진행되어야 한다.
            team.getMembers().add(member);

            em.persist(team);

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
