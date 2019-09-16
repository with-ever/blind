package kr.withever.blind.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.blind.member.repository.MemberRepository;

/**
 * @author youngjin.kim@nhnent.com
 * @since 2018-11-02
 */
@RestController
@RequestMapping("/member")
public class MemberRestController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/{memberNo}")
    public void getMember(@PathVariable long memberNo) {
//        Member member = memberRepository.findByMemberNo(memberNo);
        System.out.println("sdf");
    }
}
