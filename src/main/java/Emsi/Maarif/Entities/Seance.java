package Emsi.Maarif.Entities;

import java.util.Date;

import javax.persistence.*;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Seance 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date heureDebut;
}
