package kr.withever.blind.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import kr.withever.blind.post.entity.Post;

/**
 * @author jsg
 * @since 2019-09-16
 */
public interface PostRepository extends CrudRepository<Post, Long> {
	
	//�˻�(����+����)
	@Query(value = "select * from post where title like CONCAT('%',:findValue,'%') or content like CONCAT('%',:findValue,'%') ", nativeQuery = true)
    public List<Post> findPostByContentAndTitle(@Param("findValue") String findValue);
	
	//����
	@NonNull
	public Post save(Post post);
}
