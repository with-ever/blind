package kr.withever.blind.post.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Table(name = "post")
@Data
@DynamicInsert
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int postSeq;
    
    @Column(nullable = false)
    private String boardId;
    
    @Column(nullable = true)
    private String title;
    
    @Column(nullable = true)
    private String content;
    
//    @Column(nullable = true)
//    private Integer viewCnt;
//    
//    @Column(nullable = true)
//    private Integer likeCnt;
//    
    @CreatedDate // Entity 생성시 자동으로 날짜세팅
    private LocalDateTime regDate;
    
    @LastModifiedDate // Entity 수정시 자동으로 날짜세팅
    private LocalDateTime modDate;
    
    
    @Column(nullable = true)
    private String regId;
    
    @Column(nullable = true)
    private String regNm;
    
    @Column(nullable = true)
    private String modId;
    
    @Column(nullable = true)
    private String modNm;
    
    @Column(nullable = true)
    private String imageUrl;

	public Post(String boardId, String title, String content, int viewCnt, int likeCnt, String regId, String regNm,
			String imageUrl) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
//		this.viewCnt = viewCnt;
//		this.likeCnt = likeCnt;
		this.regId = regId;
		this.regNm = regNm;
		this.imageUrl = imageUrl;
	}
	
	public Post setUpdate(String title, String content,String modId,  String modNm) {
		this.title = title;
		this.content = content;
		this.modId = modId;
		this.modNm = modNm;
		return this;
		
	}
    
//    private String findValue;
    
    
    
}
