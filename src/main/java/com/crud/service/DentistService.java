package com.crud.service;

import com.crud.models.Dentist;
import com.crud.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private DentistRepository repo;

    @Override
    @Transactional
    public void save(Dentist p) {
        repo.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dentist> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Dentist findDentistByid(Long id) {
        return repo.findById(id).orElse(null);
    }
}