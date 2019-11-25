package kr.withever.blind.api.member;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Map;
import java.util.Optional;
import kr.withever.blind.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.withever.blind.member.entity.Member;

/**
 * @author hs85699104@gmail.com
 * @since 2019-11-23
 */
@Api(value = "/member", description = "회원 api")
@RestController
@RequestMapping("/member")
public class MemberRestController {

  @Autowired
  MemberService memberService;

  //회원 조회
  @ApiOperation(value = "회원 조회", notes = "회원 번호(memberNo)를 이용한 회원 조회", httpMethod = "GET", response = Member.class, produces = "application/json")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "memberNo", value = "회원 번호", required = true, dataType = "long", paramType = "path")
  })
  @GetMapping("/retrieve/{memberNo}")
  public @ResponseBody
  Member retrieveMember(@PathVariable("memberNo") Long memberNo) {
    return this.memberService.retrieveMember(memberNo).get();
  }

  //회원 생성
  @ApiOperation(value = "회원 생성", notes = "회원 생성", httpMethod = "POST", response = Member.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"),
      @ApiResponse(code = 500, message = "저장 오류 발생")})
  @PostMapping("/create")
  public @ResponseBody
  Long createMember(@RequestBody Member member) {
    return memberService.createMember(member);

  }

  //회원 수정, 탈퇴
  @ApiOperation(value = "회원 수정", notes = "회원 수정", httpMethod = "PUT", response = Member.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"),
      @ApiResponse(code = 500, message = "저장 중 오류 발생")})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "memberNo", value = "회원 번호", required = true, dataType = "long", paramType = "path")
  })
  @PutMapping("/modify/{memberNo}")
  public @ResponseBody
  Long modifyMember(@RequestBody Member member) {
    return memberService.modifyMember(member);
  }


  //비밀번호 변경
  @ApiOperation(value = "비밀번호 변경", notes = "비밀번호 변경", httpMethod = "PUT", response = Boolean.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"),
      @ApiResponse(code = 500, message = "저장중 오류 발생")})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "memberNo", value = "회원 번호", required = true, dataType = "long", paramType = "path")
  })
  @PutMapping("/modifyPassword/{memberNo}")
  public @ResponseBody
  boolean modifyMemberPassword(@PathVariable Long memberNo,
      @RequestBody Map<String, Object> requestParam) {

    boolean result = true;

    String password = (String) requestParam.get("password");
    String newPassword = (String) requestParam.get("newPassword");

    Member member = this.memberService.retrieveMember(memberNo).get();

    if (!member.getPassword().equals(password)) {
      return result = false;
    }

    member.setPassword(newPassword);

    this.memberService.modifyMemberPassword(member);

    return result;
  }

  // 비밀번호 찾기
  @ApiOperation(value = "비밀번호 찾기", notes = "비밀번호 찾기", httpMethod = "GET", response = Member.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"),
      @ApiResponse(code = 500, message = "저장중 오류 발생")})
  @ApiImplicitParams({
      @ApiImplicitParam(name = "memberNo", value = "회원 번호", required = true, dataType = "long", paramType = "path")
  })
  @GetMapping("/retrievePassword/{memberNo}")
  public @ResponseBody
  String retrievePasswordByMember(@PathVariable("memberNo") Long memberNo) {
    return memberService.retrievePasswordByMember(memberNo);

  }
}