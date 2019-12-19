package kr.withever.blind.member.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comm_member")
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long memberNo;
  private String name;

}
