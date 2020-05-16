package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Salle;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface SalleRepository extends
JpaRepository<Salle,Long> {
}