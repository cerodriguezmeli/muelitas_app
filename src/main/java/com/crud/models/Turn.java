package com.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turns")
@Getter @Setter
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Date day;

    @OneToOne(mappedBy = "turn")
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "turn_status_id", nullable = false)
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "patients_id", nullable = false)
    private Patient patients;

}
