package Emsi.Maarif.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Emsi.Maarif.Entities.Ticket;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface TicketRepository extends
JpaRepository<Ticket,Long> {
}