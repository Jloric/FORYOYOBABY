package soap.server;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSoap implements CommandLineRunner{
	@Autowired
	ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerSoap.class, args);
        

    }

	public void run(String... args) throws Exception {
		Endpoint endpoint = Endpoint.create(new ProduitServiceImpl());
        endpoint.publish("http://localhost:8888/ProduitWS");
        System.out.println("Le server SOAP est en ligne, le WSDL de produit est disponible sur:");
        System.err.println("http://localhost:8888/ProduitWS?wsdl");
        Produit p1= new Produit("une robe de prestige","robe.jpg",2.40, "robe bleu");
        produitRepository.save(p1);
		System.out.print(produitRepository.findById(1));
		
	}
}
