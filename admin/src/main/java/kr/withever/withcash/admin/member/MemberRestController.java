package kr.withever.withcash.admin.member;

import kr.withever.withcash.member.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youngjin.kim@nhnent.com
 * @since 2018-11-02
 */
@RestController
@RequestMapping("/member")
public class MemberRestController {

    @GetMapping("/{memberNo}")
    public Member getMember(@PathVariable int memberNo) {
        Member member = new Member();
        member.setMemberNo(1);
        member.setName("김영진");
        return member;
    }
}
