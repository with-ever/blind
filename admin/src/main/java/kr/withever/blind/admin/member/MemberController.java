package kr.withever.blind.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/list")
    public String getMemberList() {
        return "member/memberList";
    }
}
