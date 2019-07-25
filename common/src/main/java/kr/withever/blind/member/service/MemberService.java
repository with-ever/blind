package kr.withever.blind.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.withever.blind.member.entity.Member;
import kr.withever.blind.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author youngjin.kim
 * @since 2019-07-25
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(long memberNo) {
        return memberRepository.findByMemberNo(memberNo);
    }
}
