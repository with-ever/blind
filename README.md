## Blind

CREATE TABLE `bookmark_alarm` (
  `book_alram_no` int(11) NOT NULL AUTO_INCREMENT,
  `member_no` int(11) NOT NULL,
  `post_no` int(11) NOT NULL,
  `type` varchar(45) NOT NULL DEFAULT 'B' COMMENT '타입 (B : 북마크,  A : 알람 )',
  PRIMARY KEY (`book_alram_no`),
  KEY `fk_post_like_member1` (`member_no`),
  KEY `fk_bookmark_alarm_post1` (`post_no`),
  CONSTRAINT `fk_bookmark_alarm_post1` FOREIGN KEY (`post_no`) REFERENCES `post` (`post_no`),
  CONSTRAINT `fk_post_like_member1` FOREIGN KEY (`member_no`) REFERENCES `member` (`member_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ground` (
  `ground_no` int(11) NOT NULL AUTO_INCREMENT,
  `ground_type` varchar(45) NOT NULL DEFAULT '게시판 타입',
  `ground_title` varchar(45) NOT NULL DEFAULT '게시판 명',
  `use_yn` varchar(45) DEFAULT 'Y' COMMENT '사용여부\n',
  `mod_date` datetime DEFAULT NULL COMMENT '수정일',
  `reg_date` datetime DEFAULT NULL COMMENT '등록일\n',
  PRIMARY KEY (`ground_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `member` (
  `member_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원 키값',
  `email` varchar(45) NOT NULL COMMENT '회원 이메일',
  `email_approval_status` varchar(45) NOT NULL DEFAULT 'N' COMMENT '이메일 승인 상태',
  `password` varchar(45) NOT NULL COMMENT '비밀번호',
  `nickname` varchar(45) NOT NULL COMMENT '닉네임',
  `current_job_group` varchar(45) NOT NULL COMMENT '현직군',
  `current_job` varchar(45) NOT NULL COMMENT '현업계',
  `Interest_job_group` varchar(45) DEFAULT NULL COMMENT '관심직군',
  `Interest_job` varchar(45) DEFAULT NULL COMMENT '관심업계',
  `current_job_status` varchar(45) DEFAULT NULL COMMENT '현재직업상태 (일반회원)',
  `use_device` varchar(45) NOT NULL COMMENT '사용하고있는 디바이스',
  `data_created` datetime NOT NULL COMMENT '생성일',
  `date_updated` datetime DEFAULT NULL COMMENT '수정일',
  `member_type` varchar(45) NOT NULL DEFAULT 'N' COMMENT '회원타입 ( 일반 이메일 회원 : N , 회사 이메일 회원 : C )',
  `secession_yn` varchar(45) DEFAULT 'N' COMMENT '탈퇴 유무',
  `stop_yn` varchar(45) DEFAULT 'N' COMMENT '정지 유무',
  `report_cnt` int(11) DEFAULT '0' COMMENT '신고 횟수',
  PRIMARY KEY (`member_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `post` (
  `post_no` int(11) NOT NULL AUTO_INCREMENT,
  `up_post_no` int(11) NOT NULL DEFAULT '0' COMMENT '상위 글번호',
  `member_no` int(11) NOT NULL,
  `ground_no` int(11) NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '제목\n',
  `view_cnt` int(11) DEFAULT NULL COMMENT '조회수',
  `like_cnt` int(11) DEFAULT NULL COMMENT '좋아요수',
  `reg_date` datetime NOT NULL COMMENT '등록일',
  `mod_date` datetime DEFAULT NULL,
  `content` varchar(45) NOT NULL COMMENT '본문',
  `image_url` varchar(45) DEFAULT NULL COMMENT '이미지',
  `use_yn` varchar(45) DEFAULT NULL COMMENT '사용여부\n',
  PRIMARY KEY (`post_no`),
  KEY `fk_post_member` (`member_no`),
  KEY `fk_post_ground1` (`ground_no`),
  CONSTRAINT `fk_post_ground1` FOREIGN KEY (`ground_no`) REFERENCES `ground` (`ground_no`),
  CONSTRAINT `fk_post_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`member_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `reports` (
  `reports_no` int(11) NOT NULL AUTO_INCREMENT,
  `report_id` int(11) DEFAULT NULL,
  `post_no` int(11) DEFAULT NULL,
  `report_content` varchar(45) DEFAULT NULL COMMENT '신고이유',
  PRIMARY KEY (`reports_no`),
  KEY `fk_reports_post1` (`post_no`),
  CONSTRAINT `fk_reports_post1` FOREIGN KEY (`post_no`) REFERENCES `post` (`post_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

