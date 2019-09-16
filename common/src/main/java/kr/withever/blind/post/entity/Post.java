package kr.withever.blind.post.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int postSeq;
    
    private String boardId;
    
    private String title;
    
    private String content;
    
    private int viewCnt;
    
    private int likeCnt;
    
    private LocalDateTime regDate;
    
    private LocalDateTime modDate;
    
    private String regId;
    
    private String regNm;
    
    private String modId;
    
    private String modNm;
    
    private String imageUrl;
    
//    private String findValue;
    
    
}
