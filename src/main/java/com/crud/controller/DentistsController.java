package com.crud.controller;

import com.crud.models.Dentist;
import com.crud.models.Patient;
import com.crud.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentists")
public class DentistsController {
    @Autowired
    private DentistService service;

    @GetMapping("/getAll")
    public List<Dentist> getDentists(){
        List<Dentist> patientList = service.findAll();
        return patientList;
    }

    @PostMapping("/create")
    public String createDentist(@RequestBody Dentist dentist){
        service.save(dentist);

        return "se creo el dentista";
    }

    @PostMapping("/delete/{id}")
    public String deleteDentist(@PathVariable long id){
        service.delete(id);

        return "se eliminó el dentista";
    }

    @PostMapping("/get/{id}")
    public Dentist findDentistById(@PathVariable long id){
        Dentist d = service.findDentistByid(id);

        return d;
    }

    @PostMapping("/edit/{id}")
    public String editDentist(@PathVariable Long id, @RequestParam ("name") String newName, @RequestParam("lastName") String newLastName) {

        Dentist d = service.findDentistByid(id);
        d.setName(newName);
        d.setLastName(newLastName);

        service.save(d);
        return "El dentista fue editado correctamente";
    }
}
