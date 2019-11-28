CREATE TABLE IF NOT EXISTS `ground`.`member` (
  `member_no` INT NOT NULL AUTO_INCREMENT COMMENT '회원 키값',
  `email` VARCHAR(45) NOT NULL COMMENT '회원 이메일',
  `email_approval_status` VARCHAR(45) NOT NULL DEFAULT 'N' COMMENT '이메일 승인 상태',
  `password` VARCHAR(45) NOT NULL COMMENT '비밀번호',
  `nickname` VARCHAR(45) NOT NULL COMMENT '닉네임',
  `current_job_group` VARCHAR(45) NOT NULL COMMENT '현직군',
  `current_job` VARCHAR(45) NOT NULL COMMENT '현업계',
  `Interest_job_group` VARCHAR(45) NULL COMMENT '관심직군',
  `Interest_job` VARCHAR(45) NULL COMMENT '관심업계',
  `current_job_status` VARCHAR(45) NULL COMMENT '현재직업상태 (일반회원)',
  `use_device` VARCHAR(45) NOT NULL COMMENT '사용하고있는 디바이스',
  `data_created` DATETIME NOT NULL COMMENT '생성일',
  `date_updated` DATETIME NULL COMMENT '수정일',
  `member_type` VARCHAR(45)  NOT NULL DEFAULT 'N' COMMENT '회원타입 ( 일반 이메일 회원 : N , 회사 이메일 회원 : C )',
  `secession_yn` VARCHAR(45)  NULL DEFAULT 'N' COMMENT '탈퇴 유무',
  `stop_yn` VARCHAR(45) NULL DEFAULT 'N' COMMENT '정지 유무',
  `report_cnt` INT NULL DEFAULT 0 COMMENT '신고 횟수',
  PRIMARY KEY (`member_no`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ground`.`ground` (
  `ground_no` INT NOT NULL AUTO_INCREMENT,
  `ground_type` VARCHAR(45) NOT NULL DEFAULT '게시판 타입',
  `ground_title` VARCHAR(45) NOT NULL DEFAULT '게시판 명',
  `use_yn` VARCHAR(45) NULL DEFAULT 'Y' COMMENT '사용여부\n',
  `mod_date` DATETIME NULL COMMENT '수정일',
  `reg_date` DATETIME NULL COMMENT '등록일\n',
  PRIMARY KEY (`ground_no`))
ENGINE = InnoDB;

 
CREATE TABLE IF NOT EXISTS `ground`.`post` (
  `post_no` INT NOT NULL AUTO_INCREMENT,
  `up_post_no` INT NOT NULL DEFAULT 0 COMMENT '상위 글번호',
  `member_no` INT NOT NULL,
  `ground_no` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL COMMENT '제목\n',
  `view_cnt` INT NULL COMMENT '조회수',
  `like_cnt` INT NULL COMMENT '좋아요수',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `mode_date` DATETIME NULL COMMENT '수정일',
  `content` VARCHAR(45) NOT NULL COMMENT '본문',
  `image_url` VARCHAR(45) NULL COMMENT '이미지',
  `use_yn` VARCHAR(45) NULL COMMENT '사용여부\n',
  PRIMARY KEY (`post_no`),
  CONSTRAINT `fk_post_member`
    FOREIGN KEY (`member_no`)
    REFERENCES `ground`.`member` (`member_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_ground1`
    FOREIGN KEY (`ground_no`)
    REFERENCES `ground`.`ground` (`ground_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ground`.`bookmark_alarm` (
  `book_alram_no` INT NOT NULL AUTO_INCREMENT,
  `member_no` INT NOT NULL,
  `post_no` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL DEFAULT 'B' COMMENT '타입 (B : 북마크,  A : 알람 )',
  PRIMARY KEY (`book_alram_no`),
  CONSTRAINT `fk_post_like_member1`
    FOREIGN KEY (`member_no`)
    REFERENCES `ground`.`member` (`member_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookmark_alarm_post1`
    FOREIGN KEY (`post_no`)
    REFERENCES `ground`.`post` (`post_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


alter table ground.post CHANGE mode_date mod_date datetime;

SELECT `mode_date` FROM `ground`.`post`;
commit;

CREATE TABLE IF NOT EXISTS `ground`.`reports` (
  `reports_no` INT NOT NULL AUTO_INCREMENT,
  `report_id` VARCHAR(45post) NULL COMMENT '신고자',
  `post_id` INT NOT NULL COMMENT '신고 게시물 ',
  `report_content` VARCHAR(45) NULL COMMENT '신고이유',
  PRIMARY KEY (`reports_no`),
  CONSTRAINT `fk_reports_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `ground`.`post` (`post_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

commit;


select * from ground.post;
show tables;

INSERT INTO `ground`.`member`
(`member_no`,
`email`,
`email_approval_status`,
`password`,
`nickname`,
`current_job_group`,
`current_job`,
`Interest_job_group`,
`Interest_job`,
`current_job_status`,
`use_device`,
`data_created`,
`date_updated`,
`member_type`,
`secession_yn`,
`stop_yn`,
`report_cnt`)
VALUES
(000001,
'jsg@kakao.com',
'Y',
'11111',
'곤',
'',
'',
'',
'',
'',
'IPHONE',
NOW(),
NOW(),
'N',
'N',
'N',
0);



INSERT INTO `ground`.`ground`
(`ground_no`,
`ground_type`,
`ground_title`,
`use_yn`,
`mod_date`,
`reg_date`)
VALUES
(00001,
'FREE',
'자유게시판',
'Y',
now(),
now());


COMMIT;