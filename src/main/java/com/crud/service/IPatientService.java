package com.crud.service;

import com.crud.models.Patient;

import java.util.List;

public interface IPatientService {

    void save(Patient p);
    void delete(Long id);
    List<Patient> findAll();
    Patient findPatientByid(Long id);

}
