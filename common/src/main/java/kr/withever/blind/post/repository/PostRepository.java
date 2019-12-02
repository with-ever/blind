package kr.withever.blind.post.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import kr.withever.blind.post.entity.Post;

/**
 * @author jsg
 * @since 2019-09-16
 */
public interface PostRepository extends JpaRepository<Post, Long> {

  // 키워드검색

  @Query(
      value = "select * from post where title like CONCAT('%',:findValue,'%') or content like CONCAT('%',:findValue,'%') ",
      nativeQuery = true)
  public List<Post> findPostByFindValue(@Param("findValue") String findValue);

  // public List<Post> findByTitleLikeAndContentLike(String findValue);

  // 저장
  @NonNull
  public Post save(Post post);

  public List<Post> findAll();

  public List<Post> findByGroundNoAndUpPostNoAndUseYn(int groundNo, int upPostNo, String useYn);

  public Post findByPostNo(int postNo);

}
