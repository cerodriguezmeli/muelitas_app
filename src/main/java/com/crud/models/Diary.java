package com.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diary")
    //@JoinColumn(name = "turn_id", referencedColumnName = "id")
    private List<Turn> turns;

}
