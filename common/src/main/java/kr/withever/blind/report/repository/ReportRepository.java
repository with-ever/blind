package kr.withever.blind.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import kr.withever.blind.report.entity.Report;

/**
 * @author jsg
 * @since 2019-09-16
 */
public interface ReportRepository extends JpaRepository<Report, Long> {

  @NonNull
  public Report save(Report post);

}
