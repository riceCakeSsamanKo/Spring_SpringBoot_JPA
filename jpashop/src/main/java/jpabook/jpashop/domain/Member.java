package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded  //내장 타입 Address
    private Address address;

    @OneToMany(mappedBy = "member")  //Order.member에 의해서 매핑됨
    private List<Order> order = new ArrayList<>();


}
