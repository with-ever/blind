package kr.withever.blind.post.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@DynamicInsert
@NoArgsConstructor // 기본 생성자 자동생성
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int postNo;

  @Column(nullable = true)
  private int upPostNo;

  @Column(nullable = true)
  private int memberNo;

  @Column(nullable = true)
  private int groundNo;

  @Column(nullable = true)
  private String title;

  @Column(nullable = true)
  private String content;

  @Column(nullable = true)
  private int viewCnt;

  @Column(nullable = true)
  private int likeCnt;

  @CreatedDate
  private LocalDateTime regDate;

  @LastModifiedDate
  private LocalDateTime modDate;

  @Column(nullable = true)
  private String imageUrl;

  @Column(nullable = true)
  private String useYn;
}
