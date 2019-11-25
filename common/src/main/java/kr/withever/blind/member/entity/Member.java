package kr.withever.blind.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

}
