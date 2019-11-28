package kr.withever.blind.api.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.service.PostService;

/**
 * @author jsg
 * @since 2019-09-13
 */
@Api(value = "/post", description = "포스트 api")
@RestController
@RequestMapping("/post")
public class PostRestController {

  @Autowired
  private PostService postService;
  public static final int MemberNo = 000001;

  // 새글 저장
  // http://localhost:8080/post/savePost?boardId=0000002&title=2312314&content=콘텐츠으&regId=jsg&regNm=주상곤&viewCnt=0&likeCnt=0
  @ApiOperation(value = "저장 api", notes = "포스트 글 등록", httpMethod = "POST", response = Map.class,
      produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"), @ApiResponse(code = 500, message = "저장중 오류 발생")})
  @PostMapping("/savePost")
  public Map<String, Object> savePost(@RequestBody Post post) {
    Map<String, Object> rtnMap = new HashMap<String, Object>();
    post.setMemberNo(MemberNo);
    try {
      postService.savePost(post);
      rtnMap.put("code", "200");
      rtnMap.put("message", "저장성공");
    } catch (Exception e) {
      rtnMap.put("code", "500");
      rtnMap.put("message", "저장실패");
    }
    return rtnMap;
  }

  /*
   * @GetMapping("/postList") public List<Post> postList() { return postService.findAll(); }
   */
  // 포스트검색
  // http://localhost:8080/post/findPost?findValue=저장
  @GetMapping("/findPost/{findValue}")
  public Map<String, Object> findPost(@PathVariable String findValue) {
    Map<String, Object> rtnMap = new HashMap<String, Object>();
    try {
      List<Post> list = postService.findPost(findValue);
      rtnMap.put("list", list);
      rtnMap.put("code", "200");
      rtnMap.put("message", "조회성공");
    } catch (Exception e) {
      rtnMap.put("code", "500");
      rtnMap.put("message", "조회실패");
    }
    
    return rtnMap;
  }

  // 포스트 목록
  // http://localhost:8080/post/postList
  @ApiOperation(value = "포스트 목록", notes = "회원이 로그인하여 회원이 선택한 탭의 글목록", httpMethod = "GET",
      response = Map.class, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"), @ApiResponse(code = 500, message = "오류 발생")})
  @GetMapping("/{groundNo}")
  public Map<String, Object> selectedGroundPostList(@PathVariable int groundNo) {
    Map<String, Object> rtnMap = new HashMap<String, Object>();
    try {
      List<Post> list = postService.findPostList(groundNo);
      rtnMap.put("list", list);
      rtnMap.put("code", "200");
      rtnMap.put("message", "조회성공");
    } catch (Exception e) {
     
    }
    return rtnMap;
  }

  // 포스트 상세
  @ApiOperation(value = "포스트 상세", notes = "글 상세", httpMethod = "GET", response = Post.class,
      produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"), @ApiResponse(code = 500, message = "오류 발생")})
  @GetMapping("/detail/{postNo}")
  public Post selectedPostDetail(@PathVariable String postNo) {
    return null;
  }

  // 포스트 댓글 등록
  @ApiOperation(value = "포스트 상세", notes = "글 상세", httpMethod = "GET", response = Post.class,
      produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "호출 에러"), @ApiResponse(code = 500, message = "오류 발생")})
  @PutMapping("/commentSave")
  public void commnetSave(Post post) {

  }

  // 포스트 댓글 수정
  @PostMapping("/commentMod")
  public void commnetModify(Post post) {

  }

  // 포스트 신고
  @PostMapping("/reportPost")
  public void reporPost() {

  }

}
