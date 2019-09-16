package kr.withever.blind.api.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memeber")
public class MemberController {
	
	@RequestMapping("/test")
    public void getMember() {
    	System.out.println("asdf");
    	
    }
}
