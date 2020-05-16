package Emsi.Maarif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import Emsi.Maarif.Service.CinemaInitServiceImpl;
import Emsi.Maarif.Service.ICinemaInitService;

@SpringBootApplication
public class ProjectCinemaApplication implements CommandLineRunner{
	@Autowired
	private ICinemaInitService cinemaInitService;
	public static void main(String[] args) {
		SpringApplication.run(ProjectCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{

		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPalces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
	}

}
