package Emsi.Maarif.Entities;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor  @ToString
public class Salle 
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nombrePlace;
	@ManyToOne @JoinColumn(name ="id_cinema")
	 @JsonProperty(access = Access.WRITE_ONLY)
	private Cinema cinema;
	@OneToMany(mappedBy="salle")
	 @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Place> places;
	@OneToMany(mappedBy="salle")
	 @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Projection> projections;

	
}
