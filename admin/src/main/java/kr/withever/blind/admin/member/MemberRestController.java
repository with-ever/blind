package kr.withever.blind.admin.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.blind.member.entity.Member;
import kr.withever.blind.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author youngjin.kim@nhnent.com
 * @since 2018-11-02
 */
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberRepository memberRepository;

    @GetMapping("/{memberNo}")
    public Member getMember(@PathVariable long memberNo) {
        Member member = memberRepository.findByMemberNo(memberNo);
        System.out.println(member.getName());
        return member;
    }
}
