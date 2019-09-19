CREATE DATABASE `withever_ground` DEFAULT CHARACTER SET utf8 ;


CREATE TABLE `withever_ground`.`mb_member` (
  `member_no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`member_no`),
  UNIQUE INDEX `member_no_UNIQUE` (`member_no` ASC));