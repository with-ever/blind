package kr.withever.blind.api.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.withever.blind.post.service.PostService;

/**
 * @author jsg
 * @since 2019-09-13
 */
@Api(value = "/ground",description = "그라운드 api")
@RestController
@RequestMapping("/ground")
public class GroundRestController {

    @Autowired
    private PostService postService;
    
    
    //회원 로그인시 카테고리 정보
    @GetMapping("/list")
    public void memberCategory() {
    	
    }
    
    
}
