package kr.withever.blind.member.repository;

import org.springframework.data.repository.CrudRepository;

import kr.withever.blind.member.entity.Member;

/**
 * @author youngjin.kim
 * @since 2019-07-25
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByMemberNo(long memberNo);
}
