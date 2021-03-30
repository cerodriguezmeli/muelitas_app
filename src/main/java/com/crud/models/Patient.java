package com.crud.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
@Getter @Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String dni;
     @Column(name = "birth_date")
      private Date birthDate;
    private String phone;
    private String email;

}
