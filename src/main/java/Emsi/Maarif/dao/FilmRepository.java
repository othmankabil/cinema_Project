package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Film;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface FilmRepository extends
JpaRepository<Film,Long> {
}