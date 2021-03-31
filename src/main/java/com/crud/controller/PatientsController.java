package com.crud.controller;

import com.crud.models.Patient;
import com.crud.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientsController {

    @Autowired
    private IPatientService service;

    @GetMapping("/getAll")
    public List<Patient> getPatients(){
        List<Patient> patientList = service.findAll();
        return patientList;
    }

    @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
            service.save(patient);

        return "se creo el paciente";
    }

    @PostMapping("/delete/{id}")
    public String deletePatient(@PathVariable long id){
        service.delete(id);

        return "se eliminó el paciente";
    }

    @PostMapping("/get/{id}")
    public Patient findPatientById(@PathVariable long id){
        Patient p = service.findPatientByid(id);

        return p;
    }

    @PostMapping("/edit/{id}")
    public String editPatients(@PathVariable Long id, @RequestParam ("name") String newName, @RequestParam("lastName") String newLastName) {

        Patient p = service.findPatientByid(id);
        p.setName(newName);
        p.setLastName(newLastName);

        service.save(p);
        return "El paciente fue editado correctamente";
    }

}
