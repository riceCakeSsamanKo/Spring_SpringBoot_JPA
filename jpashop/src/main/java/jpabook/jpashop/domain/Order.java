package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  //Order에서 Member는 다대일 관계
    @JoinColumn(name = "member_id")  // 외래 키(fk), 연관관계 주인
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  // persist(order)하면 orderItem들도 모두 저장
    private List<OrderItem> orderItems = new ArrayList<>(); //OrderItem.order에 의해서 매핑됨

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")  // 외래 키(fk), 연관관계 주인
    private Delivery delivery;

    private LocalDateTime orderDate;  //주문 시간 (테이블명:order_date)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;  //주문 상태 [ORDER,CANCEL]
}
