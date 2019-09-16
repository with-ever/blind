package kr.withever.blind.admin.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/findValue")
    public List<Post> getMember(@RequestParam(value = "findValue") String findValue) {
        List<Post> post = postRepository.findPostByContentAndTitle(findValue);
        return post;
    }
}
