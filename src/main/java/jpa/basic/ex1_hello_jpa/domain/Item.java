package jpa.basic.ex1_hello_jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 상속 전략 선택
@DiscriminatorColumn(name = "DTYPE") // 자식을 구분할 컬럼 명
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
}
