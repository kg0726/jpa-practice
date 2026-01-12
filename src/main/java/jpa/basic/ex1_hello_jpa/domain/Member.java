package jpa.basic.ex1_hello_jpa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // JPA가 관리할 객체임을 선언
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)// DB의 PK와 매핑
    private Long id;
    private String username;

//    @OneToMany(mappedBy = "member")  // 연관관계의 주인이 아님을 표시함 -> Product 클래스의 member 필드에 의해 매핑됨
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member") // 연관관계의 주인이 아님을 표시함
    private List<Order> orders = new ArrayList<>();

    public Member(String username) {
        this.username = username;
    }
}