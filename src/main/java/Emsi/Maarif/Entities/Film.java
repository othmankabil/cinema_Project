package Emsi.Maarif.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String decription;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
	@OneToMany(mappedBy="film")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Projection> projections;
	@ManyToOne
	private Categorie categorie;
}
