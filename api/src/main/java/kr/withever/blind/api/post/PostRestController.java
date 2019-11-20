package kr.withever.blind.api.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.service.PostService;

/**
 * @author jsg
 * @since 2019-09-13
 */
@Api(value = "/post",description = "포스트 api")
@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    private PostService postService;
    
    //새글 저장
    //http://localhost:8080/post/savePost?boardId=0000002&title=2312314&content=콘텐츠으&regId=jsg&regNm=주상곤&viewCnt=0&likeCnt=0
    @ApiOperation(value = "저장 api", notes = "포스트 글 등록", httpMethod = "Put", response = Post.class, produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "호출 에러"),
        				    @ApiResponse(code = 500, message = "저장중 오류 발생") })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "boardId", value = "User's name", required = true, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "email", value = "User's email", required = false, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "query")
      })
    @PutMapping("/savePost")
    public Post savePost(@ModelAttribute Post post) {
    	System.out.println(post.getLikeCnt());
    	System.out.println(post.getViewCnt());
    	postService.savePost(post);
        
        return post;
    }
    
	/*
	 * @GetMapping("/postList") public List<Post> postList() { return
	 * postService.findAll(); }
	 */    
    //포스트검색
    //http://localhost:8080/post/findPost?findValue=저장
    @GetMapping("/findPost")
    public List<Post> findPost(String findValue) {
        return postService.findPost(findValue);
	}
    
    //포스트 목록
    //http://localhost:8080/post/postList
    @ApiOperation(value = "포스트 목록", notes = "회원이 로그인하여 회원이 선택한 탭의 글목록", httpMethod = "Get", response = Post.class ,responseContainer="List" , produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "호출 에러"),
        				    @ApiResponse(code = 500, message = "오류 발생") })
    @GetMapping("/{groundSeq}")
    public List<Post> selectedGroundPostList(@PathVariable String groundSeq){
    	return null;
    }
    
    
    //포스트 상세 
    @ApiOperation(value = "포스트 상세", notes = "글 상세", httpMethod = "Get", response = Post.class, produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "호출 에러"),
        				    @ApiResponse(code = 500, message = "오류 발생") })
    @GetMapping("/{postNo}")
    public Post selectedPostDetail(@PathVariable String postNo){
    	return null;
    }
    
    //포스트 댓글 등록
    @ApiOperation(value = "포스트 상세", notes = "글 상세", httpMethod = "Get", response = Post.class, produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "호출 에러"),
        				    @ApiResponse(code = 500, message = "오류 발생") })
    @PutMapping("/commentSave")
    public void commnetSave(Post post) {
    	
    }
    
    //포스트 댓글 수정
    @PostMapping("/commentMod")
    public void commnetModify(Post post) {
    	
    }
    
    //포스트 신고
    @PostMapping("/reportPost")
    public void reporPost() {
    
    }
    
}
