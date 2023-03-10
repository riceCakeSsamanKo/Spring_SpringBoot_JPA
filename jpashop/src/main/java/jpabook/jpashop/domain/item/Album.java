package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")  // 싱글테이블이니 DB 입장에서 구분하기 위하여 설정
@Getter @Setter
public class Album extends Item{

    private String artist;
    private String etc;
}
