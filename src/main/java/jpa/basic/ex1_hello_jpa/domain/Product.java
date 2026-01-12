package jpa.basic.ex1_hello_jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // (1) JPA가 관리하는 엔티티임을 선언
@Table(name = "PRODUCT") // (2) DB의 PRODUCT 테이블과 매핑
@Getter @Setter
@NoArgsConstructor // (3) JPA 필수: 기본 생성자
public class Product {

    @Id // (4) 기본 키(PK) 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (5) PK 생성 전략 (DB에 위임)
    private Long id;

    @Column(name = "name", nullable = false) // (6) 컬럼 매핑 및 제약조건
    private String productName;

    private int productPrice;
    private int productAmount;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    private LocalDate regDate;

    @Lob
    @Column(name = "DESC")
    private String description;

//    @ManyToOne // 상품(N) : 회원(1)
//    @JoinColumn(name = "MEMBER_ID") // DB의 어떤 FK 컬럼과 매핑할 지 지정
//    private Member member;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

    // 편의를 위한 생성자
    public Product(String productName, int productPrice, int productAmount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }
}