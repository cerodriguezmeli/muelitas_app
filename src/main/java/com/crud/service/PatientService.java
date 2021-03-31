package com.crud.service;

import com.crud.models.Patient;
import com.crud.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService implements IPatientService {

   @Autowired
   private PatientRepository repo;

    @Override
    @Transactional
    public void save(Patient p) {
        repo.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        List<Patient> patientList = repo.findAll();
        return patientList;
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findPatientByid(Long id) {
        Patient patient = repo.findById(id).orElse(null);
        return patient;
    }
}
