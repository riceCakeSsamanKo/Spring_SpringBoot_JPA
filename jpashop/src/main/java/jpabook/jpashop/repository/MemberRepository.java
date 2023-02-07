package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        //createQuery로 DB에 JPQL 주고 Member.class 반환받음
        List<Member> result =
                em.createQuery("select m from Member m", Member.class).
                getResultList();

        return result;
    }

    public List<Member> findByName(String name){
        List<Member> result =
                em.createQuery("select m from Member m where m.name = :name", Member.class).
                setParameter("name", name).  // :name에 String name 대입함
                getResultList();

        return result;
    }
}
