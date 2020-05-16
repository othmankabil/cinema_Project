package Emsi.Maarif.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Projection 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateProjection;
	private double prix;
	@ManyToOne
	 @JsonProperty(access = Access.WRITE_ONLY)
	private Salle salle;
	@ManyToOne
	private Film film;
	@OneToMany(mappedBy="projection")
	 @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Ticket> tickets;
	@ManyToOne
	private Seance seance;
}
