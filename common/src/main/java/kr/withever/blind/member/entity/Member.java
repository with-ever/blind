package kr.withever.blind.member.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long memberNo;
  private String email;
  private String emailApprovalStatus;
  private String password;
  private String nickname;
  private String currentJobGroup;
  private String currentJob;
  private String InterestJobGroup;
  private String InterestJob;
  private String currentJobStatus;
  private String useDevice;
  private Date dateCreated;
  private Date dateUpdated;
  private MemberType memberType;
  private String secessionYn;
  private String stopYn;
  private int reportCnt;

  private String test;

}
