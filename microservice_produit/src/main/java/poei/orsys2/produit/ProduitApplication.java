package poei.orsys2.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;
import poei.orsys2.produit.service.ProduitServiceImpl;

import javax.xml.ws.Endpoint;


@SpringBootApplication
public class ProduitApplication implements CommandLineRunner {
	@Autowired
	ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
		}


	@Override
	public void run(String... args){
		Produit p1=new Produit("description","image.jpg",15.4,"titre");
		Produit p2=new Produit("description2","image24.jpg",25.3,"titre");
		Produit p3=new Produit("description3","image45.jpg",41.5,"titre");
		produitRepository.save(p1);
		produitRepository.save(p2);
		produitRepository.save(p3);
	}
}

