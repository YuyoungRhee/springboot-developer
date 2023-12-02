package me.rheeyouyoung.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> { //관리할 엔티티 이름, 기본키타입
}
