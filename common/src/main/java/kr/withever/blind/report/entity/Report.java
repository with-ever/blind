package kr.withever.blind.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reports")
@Data
@DynamicInsert
@NoArgsConstructor // 기본 생성자 자동생성
public class Report {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reportsNo;

  @Column(nullable = true)
  private int reportId;

  @Column(nullable = true)
  private int postNo;

  @Column(nullable = true)
  private String reportContent;
}
