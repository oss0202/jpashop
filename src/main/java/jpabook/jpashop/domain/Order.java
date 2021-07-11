package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")//ORDER의 경우 DB S에약어로 들어간 경우가 많아서 ORDERS로 테이브 이름을 설정해 줍니다.
public class Order {

    @Id@GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    //    @Column(name = "ORDER_DATE")
//    Boot의 경우 JAVA Camel Case를 DB의 Under Scope로 자동 변환해 주기로 한다.
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)//Order로 들어가면 나중에 순서가 꼬일 수 있다 -> 중간에 추가될 경우
    private OrderStatus statue;
}
