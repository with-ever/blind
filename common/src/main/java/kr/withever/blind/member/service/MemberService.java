package kr.withever.blind.member.service;

import kr.withever.blind.member.entity.Member;
import kr.withever.blind.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @author hs85699104@gmail.com
 * @since 2019-11-23
 */
@Service
public class MemberService {

  @Autowired
  MemberRepository memberRepository;

  // 회원 검색
  public Optional<Member> retrieveMember(Long memberNo) {
    return memberRepository.findById(memberNo);
  }

  // 회원 추가
  public Long createMember(Member member) {
    Member createMember = memberRepository.save(member);
    return createMember.getMemberNo();
  }

  //회원 수정
  public Long modifyMember(Member member) {
    Member modifyMember = memberRepository.save(member);
    return modifyMember.getMemberNo();

  }

  //회원 탈퇴
  public void removeMember(Long memberId) {
    memberRepository.deleteById(memberId);
  }

  //비밀번호 번경
  public Long modifyMemberPassword(Member member) {
    Member modifyMember = memberRepository.save(member);
    return modifyMember.getMemberNo();
  }

  // 비밀번호 찾기
  public String retrievePasswordByMember(Long memberNo) {
    return memberRepository.findByPassword(memberNo).getPassword();
  }

//    void addMemberType(Member member){} //회원 구분 설정 (일반 이메일, 회원 이메일)
//
//    void addUseDevice(Long memberId, String device){} //사용기기 등록
//
//    void modifyUseDevice(Long memberId, String device){} //사용기기 업데이트
//
//    String sendEmail(Member member){} // 인증 이메일 전송

}
