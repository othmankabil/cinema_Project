package Emsi.Maarif.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Emsi.Maarif.Entities.*;
import Emsi.Maarif.dao.*;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService 
{
	@Autowired private VilleRepository villeRepository;
	@Autowired private CinemaRepository cinemaRepository;
	@Autowired private SalleRepository salleRepository;
	@Autowired private PlaceRepository placeRepository; 
	@Autowired private SeanceRepository seanceRepository; 
	@Autowired private FilmRepository filmRepository;
	@Autowired private ProjectionRepoitory projectionRepository; 
	@Autowired private CategorieRepository categorieRepository; 
	@Autowired private TicketRepository ticketRepository;
	
	@Override
	public void initVilles() {
		Stream.of("Casablanca","Marrakech","Rabat","Tanger").forEach(nameVille->{
			Ville ville=new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinemas() 
	{
		villeRepository.findAll().forEach(v->{
			Stream.of("MegaRama","IMAX","FOUNOUN","CHAHRAZAD","DAOULIZ").forEach(nameCinema->{
				Cinema cinema=new Cinema(); 
				cinema.setName(nameCinema); 
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
				}); });
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->{ for(int i=0;i<cinema.getNombreSalles();i++) 
		{ Salle salle=new Salle(); salle.setName("Salle "+(i+1)); 
		salle.setCinema(cinema); salle.setNombrePlace(15+(int)(Math.random()*20)); 
		salleRepository.save(salle); 
		}});
		
	}

	@Override
	public void initPalces() {
		salleRepository.findAll().forEach(salle->{ for(int i=0;i<salle.getNombrePlace();i++)
		{ Place place=new Place(); place.setNumero(i+1); 
		place.setSalle(salle); 
		placeRepository.save(place); } });
		
	}

	@Override
	public void initSeances() {
		DateFormat dateFormat=new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{ Seance seance=new Seance(); 
		try { seance.setHeureDebut(dateFormat.parse(s)); seanceRepository.save(seance); } 
		catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		}
		});
		
	}

	@Override
	public void initCategories() {
		Stream.of("Histoire","Actions","Fiction","Drama").forEach(cat->{ 
			Categorie categorie=new Categorie();
			categorie.setName(cat); 
			categorieRepository.save(categorie); });
		
	}

	@Override
	public void initFilms() {
		double[] durees=new double[] {1,1.5,2,2.5,3}; 
		List<Categorie> categories=categorieRepository.findAll();
		Stream.of("12 Hommes en colere","Forrest Gump","Green Book","La Ligne Verte","Le Parrain","Le Seigneur des anneaux").forEach(titreFilm->{ 
			Film film=new Film(); film.setTitre(titreFilm); film.setDuree(durees[new Random().nextInt(durees.length)]);
		film.setPhoto(titreFilm.replaceAll(" ", "")+".jpg");
		film.setCategorie(categories.get(new Random().nextInt(categories.size()))); filmRepository.save(film); });
		
	}

	@Override
	public void initProjections() {
		double[] prices = new double[] {30,60,50,40,90};
		villeRepository.findAll().forEach(v->{
			v.getCinemas().forEach(c->{
				c.getSalles().forEach(s->{
					filmRepository.findAll().forEach(f->
					{
						seanceRepository.findAll().forEach(sc->
						{
							Projection pro = new Projection();
							pro.setDateProjection(new Date());
							pro.setFilm(f);
							pro.setPrix(prices[new Random().nextInt(prices.length)]);
							pro.setSalle(s);
							pro.setSeance(sc);
							projectionRepository.save(pro);
						});	
					});
				});
			});
		}
		);
		
	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(p->{ p.getSalle().getPlaces().forEach(place->{
			Ticket ticket=new Ticket(); ticket.setPlace(place); 
			ticket.setPrix(p.getPrix()); ticket.setProjection(p); 
			ticket.setReserve(false); ticketRepository.save(ticket);
			}); 
		}); 
		}
		
}



