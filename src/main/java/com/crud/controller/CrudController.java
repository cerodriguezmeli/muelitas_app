package com.crud.controller;

import com.crud.models.Patient;
import com.crud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CrudController {

    @Autowired
    private PatientService service;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        List<Patient> patientList = service.findAll();
        return patientList;
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Patient patient){
            service.save(patient);

        return "se creo el usuario";
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable long id){
        service.delete(id);

        return "se eliminó el usuario";
    }

    @PostMapping("/getPatient/{id}")
    public Patient findPatientById(@PathVariable long id){
        Patient p = service.findPatientByid(id);

        return p;
    }

    @PostMapping("/editPatient/{id}")
    public String editStudents(@PathVariable Long id, @RequestParam ("name") String newName, @RequestParam("lastName") String newLastName) {

        Patient p = service.findPatientByid(id);
        p.setName(newName);
        p.setLastName(newLastName);

        service.save(p);
        return "El usuario fue editado correctamente";
    }

}
