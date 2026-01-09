package jpa.basic.ex1_hello_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpa.basic.ex1_hello_jpa.domain.Member;
import jpa.basic.ex1_hello_jpa.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JpaMain implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        System.out.println("시작");
//
//        // 1. 비영속 상태
//        Product product = new Product("JPA 책", 30000, 10);
//
//        // 2. 영속 상태(영속성 컨텍스트에 저장)
//        System.out.println("--- PERSIST 실행 전 ---");
//        em.persist(product);
//        System.out.println("---PERSIST 실행 후 ---");
//
//        // 3. 1차 캐시 확인
//        Product findProduct = em.find(Product.class, product.getProductId());
//        System.out.println("찾은 상품: " + findProduct.getProductName());
//
//        // 4. 변경 감지(Dirty Checking)
//        findProduct.setProductPrice(35000);
//        System.out.println("--- 트랜잭션 종료 직전(플러시 발생 예정) --- ");

        // 1. 회원 저장
        Member member = new Member();
        member.setUsername("강사님");
        em.persist(member);

// 2. 상품 저장
        Product product = new Product();
        product.setProductName("JPA 강의");
        product.setMember(member); // 연관관계 설정 (주인에게 값을 입력!)
        em.persist(product);
    }
}
