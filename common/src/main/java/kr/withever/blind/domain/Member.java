package kr.withever.blind.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "member")
public class Member {
    private int id;
    private String email;
}
