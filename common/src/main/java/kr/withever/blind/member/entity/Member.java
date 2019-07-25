package kr.withever.blind.member.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comm_member")
public class Member {
    private long memberNo;
    private String name;
}
