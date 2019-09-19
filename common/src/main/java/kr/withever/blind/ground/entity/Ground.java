package kr.withever.blind.ground.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gr_ground")
@Getter
@Setter
public class Ground {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groundNo;

    private String name;



}
