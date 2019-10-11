package kr.withever.blind.api.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.service.PostService;

/**
 * @author jsg
 * @since 2019-09-13
 */
@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    private PostService postService;
    
    //새글 저장
    //http://localhost:8080/post/savePost?boardId=0000002&title=2312314&content=콘텐츠으&regId=jsg&regNm=주상곤&viewCnt=0&likeCnt=0
    @PutMapping("/savePost")
    public Post savePost(Post post) {
    	System.out.println(post.getLikeCnt());
    	System.out.println(post.getViewCnt());
    	postService.savePost(post);
        
        return post;
    }
    
    //스트 목록
    //http://localhost:8080/post/postList
    @GetMapping("/postList")
    public List<Post> postList() {
        return postService.findAll();
	}
    
    //포스트검색
    //http://localhost:8080/post/findPost?findValue=저장
    @GetMapping("/findPost")
    public List<Post> findPost(String findValue) {
        return postService.findPost(findValue);
	}
    
    
}
