package Emsi.Maarif.web;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Emsi.Maarif.Entities.Film;
import Emsi.Maarif.Entities.Ticket;
import Emsi.Maarif.dao.FilmRepository;
import Emsi.Maarif.dao.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
class TicketForm{
private String nomClient;
private int codePayement;
private List<Long> tickets=new ArrayList<>();
}
@RestController
public class CinemaRestController
{
	@Autowired private FilmRepository filmRepository;
	@Autowired private TicketRepository ticketRepository;
	
	@GetMapping(path = "imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable(name="id") long id) throws IOException
	{
		Film f=filmRepository.findById(id).get();
		String photoName=f.getPhoto();
		File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
		Path path=Paths.get(file.toURI());
		System.out.print("before");
		return Files.readAllBytes(path);
	}
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketFrom) {
		List<Ticket> listTickets=new ArrayList<>();
		ticketFrom.getTickets().forEach(idTicket->{
			
			Ticket ticket=ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketFrom.getNomClient());
			ticket.setReserve(true);
			ticket.setCodePayement(ticketFrom.getCodePayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		return listTickets;
	}	


}

	
	

