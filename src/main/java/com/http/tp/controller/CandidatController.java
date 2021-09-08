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

import com.http.tp.model.repositories.CandidatRepository;
import com.http.tp.exception.ResourceNotFoundException;
import com.http.tp.model.entities.Candidat;
import com.http.tp.model.entities.Formation;

@RestController
@RequestMapping("candidat")
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
@GetMapping("/{id}")
public Candidat getDeviceById(@PathVariable(value = "id") Long candidatId)
{
return candidatRepository.findById(candidatId).orElseThrow(() -> new ResourceNotFoundException("candidat", "id",candidatId));
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteFormation(@PathVariable(value = "id") Long candidatId) {
    Candidat c = candidatRepository.findById(candidatId)
            .orElseThrow(() -> new ResourceNotFoundException("admin", "id", candidatId));

    candidatRepository.delete(c);

    return ResponseEntity.ok().build();
}


}
