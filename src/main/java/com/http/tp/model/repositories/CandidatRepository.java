package com.http.tp.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.http.tp.model.entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
