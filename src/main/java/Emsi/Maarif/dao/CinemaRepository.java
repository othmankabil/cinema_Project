package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Cinema;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface CinemaRepository extends
JpaRepository<Cinema,Long> {
}