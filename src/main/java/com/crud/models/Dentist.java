package com.crud.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dentists")
@Getter @Setter
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String dni;
     @Column(name = "birth_date")
    //@Temporal(TemporalType.TIME)
       private Date birthDate;
    private String phone;
    private String email;
    @Column(name = "code_mp")
    private String codeMp;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "diarys_id", referencedColumnName = "id")
    private List<Diary> diarys;
}
