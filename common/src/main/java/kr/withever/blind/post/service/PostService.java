package kr.withever.blind.post.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.withever.blind.post.entity.Post;
import kr.withever.blind.post.repository.PostRepository;


/**
 * @author youngjin.kim
 * @since 2019-07-25
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    @Transactional(readOnly = true)
//    public Post getFindPost(String findData) {
//        return postRepository.findPostByContentAndTitle(findData);
//    }
}
