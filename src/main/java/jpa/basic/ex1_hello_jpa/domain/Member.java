package jpa.basic.ex1_hello_jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 객체임을 선언
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)// DB의 PK와 매핑
    private Long id;
    private String username;

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}