package com.http.tp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.http.tp.model.repositories.CandidatRepository;
import com.http.tp.model.entities.Candidat;

@RestController
@RequestMapping
public class CandidatController {
@Autowired
CandidatRepository candidatRepository;
@GetMapping
public List<Candidat> getAllCandidats()
{
	return  candidatRepository.findAll();

}
@PostMapping
public Candidat addCandidat(@Valid @RequestBody Candidat candidat)
{
	return candidatRepository.save(candidat);
	
}



}
