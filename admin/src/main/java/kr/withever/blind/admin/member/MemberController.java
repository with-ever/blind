package kr.withever.blind.admin.member;

import kr.withever.blind.member.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

  @RequestMapping("/list")
  public String getMemberList() {
    Member member = new Member();
    return "member/memberList";

  }
}
