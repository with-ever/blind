package kr.withever.blind.admin.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.repository.PostRepository;

/**
 * @author jsg
 * @since 2019-09-13
 */
@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    private PostRepository postRepository;
    
    //검색(제목+내용)
    @PutMapping("/savePost")
    public Post savePost(Post post) {
        postRepository.save(post);
        return post;
    }
    
    
    
}
