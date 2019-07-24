package kr.withever.blind.api.member;

import kr.withever.blind.advertisement.Advertisement;
import kr.withever.blind.domain.Member;
import kr.withever.blind.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/member"})
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    public void getMember() {
        Advertisement advertisement = new Advertisement();
    }

    @RequestMapping("/insert")
    public void insertMember(@RequestParam String str) {

        Member member = new Member();
        member.setEmail("test");

    }
}
