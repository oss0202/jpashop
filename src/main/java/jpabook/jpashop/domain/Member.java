package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(indexes = @Index(columnList = "MEMBER_ID"))
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    // DB제약사항도 추가한다 -> 이게 없을 경우 DB를 조회해 봐야한다.
    @Column(length = 10)
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    @JoinColumn(name = "MEMBER_ID")
    private List<Order> orders = new ArrayList<>();// 초기값 세팅, NPE 예방, 메모리를 약간 잡아먹긴 함
}
