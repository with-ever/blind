package kr.withever.blind.admin.member;

import kr.withever.blind.member.entity.Member;
import kr.withever.blind.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/{memberNo}")
  public Member getMember(@PathVariable long memberNo) {
    return null;
  }
}
