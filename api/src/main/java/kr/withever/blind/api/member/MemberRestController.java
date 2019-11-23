package kr.withever.blind.api.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.withever.blind.member.entity.Member;
import kr.withever.blind.member.repository.MemberRepository;
/**
 * @author youngjin.kim@nhnent.com
 * @since 2018-11-02
 */
@Api(value = "/member",description = "회원 api")
@RestController
@RequestMapping("/member")
public class MemberRestController {

    @Autowired
    private MemberRepository memberRepository;

    //회원번호 정보 조회
    @GetMapping("/{memberNo}")
    public Member getMember(@PathVariable long memberNo) {
//        Member member = memberRepository.findByMemberNo(memberNo);

    	return null;
    }
    
    //회원 로그인
    @GetMapping("/login")
    public void memberLogin(Member member) {
        System.out.println("sdf");
    }
    
    
    //회원 정보 수정 및 탈퇴시 y / n
    @PostMapping("/infoUpdate")
    public void memberInfoUpdate(Member member) {
    }
 

    //회원가입
    @PutMapping("/join")
    public void memberJoin(Member member) {
    	
    }

    //이메일 인증 신청
    @GetMapping("/{email}")
    public void memberEmailAuthRequest(@PathVariable String email) {
    	//메일 보내고 사용자가 인증 버튼 누르면
    	//업데이트 된다.
    }
    
    
    //북마크 알림 등록
    @PutMapping("/registBookmarkAlram")
    public void registBookmarkOrAlram() {

    }
    
    
    //북마크한 목록 조회
    @GetMapping("/bookmark/{memberNo}")
    public void bookmarkList() {
    	
    }
    
    
    
    
}