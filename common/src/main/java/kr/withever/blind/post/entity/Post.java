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

@Entity
@Table(name = "post")
@Data
@DynamicInsert
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int postNo;
    
    @Column(nullable = true)
    private String upPostNo;
    
    @Column(nullable = true)
    private String groundNo;
    
    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String content;
    
    @Column(nullable = true)
    private int viewCnt;
    
    @Column(nullable = true)
    private int likeCnt;
        
    @CreatedDate // Entity ������ �ڵ����� ��¥����
    private LocalDateTime regDate;
    
    @LastModifiedDate // Entity ������ �ڵ����� ��¥����
    private LocalDateTime modDate;
    
    @Column(nullable = true)
    private String imageUrl;
    
    @Column(nullable = true)
    private String useyN;
    
    public Post() {
		super();
	}
}
