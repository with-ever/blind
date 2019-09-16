package kr.withever.blind.post.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.repository.PostRepository;


/**
 * @author jsg
 * @since 2019-09-16
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
