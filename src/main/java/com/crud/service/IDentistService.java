package com.crud.service;


import com.crud.models.Dentist;

import java.util.List;

public interface IDentistService {

    void save(Dentist d);
    void delete(Long id);
    List<Dentist> findAll();
    Dentist findDentistByid(Long id);

}