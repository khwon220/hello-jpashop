package jpabook.jpashop01;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop01.domain.Book;
import jpabook.jpashop01.domain.Member;
import jpabook.jpashop01.domain.Order;
import jpabook.jpashop01.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//            Member member = em.find(Member.class, memberId);
//            order.getMember();

//            Order order = new Order();
//            em.persist(order);

//            order.addOrderItem(new OrderItem());
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

            // 상속관계 매핑
           Book book = new Book();
           book.setName("JPA");
           book.setAuthor("김영한");

           em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
