package com.http.tp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.http.tp.model.entities.Formation;
import com.http.tp.model.repositories.FormationRepository;

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



}
