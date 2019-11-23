package kr.withever.blind.ground.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;

@Entity
@Table(name = "ground")
@Data
public class Ground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groundNo;
    
    @Column
    private GroundType groundType;
    
    @Column
    private String groundTitle;
    
    @Column 
    private String useYn;
    
    @CreatedDate 
    private LocalDateTime regDate;
    
    @LastModifiedDate
    private LocalDateTime modDate;
  
    public Ground() {
      super();
    }
    public Ground(int groundNo, GroundType groundType, String groundTitle) {
      super();
      this.groundNo = groundNo;
      this.groundType = groundType;
      this.groundTitle = groundTitle;
    }

}
