package com.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diarys")
@Getter
@Setter
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "start_time")
   private Date startTime;
   @Column(name = "ending_time")
     private Date endingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turn_id", referencedColumnName = "id")
    private Turn turn;


}
