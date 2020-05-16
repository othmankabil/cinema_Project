package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import Emsi.Maarif.Entities.Categorie;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CategorieRepository extends
JpaRepository<Categorie,Long> {
}