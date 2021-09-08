package com.http.tp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.http.tp.model.entities.Formation;
import com.http.tp.model.repositories.FormationRepository;
import com.http.tp.exception.ResourceNotFoundException;
@RestController
@RequestMapping("formation")
public class FormationController {
@Autowired
FormationRepository formationRepository;
@GetMapping
public List<Formation> getFormations()
{
return (List<Formation>) formationRepository.findAll();	
}
@PostMapping
public Formation addFormation(@RequestBody @Valid Formation  fo)
{
return formationRepository.save(fo);	
}
@GetMapping("/{id}")
public Formation getDeviceById(@PathVariable(value = "id") Long FormationId)
{
return formationRepository.findById(FormationId).orElseThrow(() -> new ResourceNotFoundException("device", "id",FormationId));
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteFormation(@PathVariable(value = "id") Long FormationId) {
    Formation f = formationRepository.findById(FormationId)
            .orElseThrow(() -> new ResourceNotFoundException("admin", "id", FormationId));

    formationRepository.delete(f);

    return ResponseEntity.ok().build();
}
}
