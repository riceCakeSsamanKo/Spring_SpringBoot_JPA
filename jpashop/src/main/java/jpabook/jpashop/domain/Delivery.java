package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;


    @OneToOne(mappedBy = "delivery",fetch = LAZY)  //Order.delivery에 의해서 매핑됨
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)  // enum이 숫자로 매칭되는 것이 아니라 String으로 매칭
    private DeliveryStatus status;  //READY, COMP
}
