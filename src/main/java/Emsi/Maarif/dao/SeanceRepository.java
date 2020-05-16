package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Seance;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface SeanceRepository extends
JpaRepository<Seance,Long> {
}