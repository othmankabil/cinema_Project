package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Ville;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface VilleRepository extends
JpaRepository<Ville,Long> {
}