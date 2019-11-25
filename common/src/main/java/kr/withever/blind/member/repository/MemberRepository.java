package kr.withever.blind.member.repository;

import kr.withever.blind.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author hs85699104@gmail.com
 * @since 2019-11-23
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  Member findByPassword(Long memberNo);
}
