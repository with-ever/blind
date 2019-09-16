package kr.withever.blind.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.withever.blind.post.entity.Post;

/**
 * @author jsg
 * @since 2019-07-25
 */
public interface PostRepository extends CrudRepository<Post, Long> {
	
	@Query(value = "select * from post where title like CONCAT('%',:findValue,'%') or content like CONCAT('%',:findValue,'%') ", nativeQuery = true)
    List<Post> findPostByContentAndTitle(@Param("findValue") String findValue);
}
