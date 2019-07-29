package kr.withever.blind.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comm_member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long memberNo;
    private String name;
}
