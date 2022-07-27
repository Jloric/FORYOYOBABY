package soap.server;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;


@WebService
public class ProduitServiceImpl implements ProduitService{
	 	@Autowired
	    ProduitRepository produitRepository;

	    public List<Produit> getProduits() {
	        System.err.println("Voici la liste des produits");
	        return produitRepository.findAll();
	    }

	    public Produit create(Produit p) {
	        produitRepository.save(p);
	        System.err.println("le produit a était crée");
	        return p;
	    }

	   
	    public Produit findById(@WebParam(name="id") int id){
	        Produit p=produitRepository.findById(id).get();
	        System.out.println("voici le porduit demander:");
	        System.err.println(p);
	        return p;
	    }

	    
	    public void deleteProduit(@WebParam(name="id")int id) {
	        produitRepository.deleteById(id);
	        System.err.println("le produit a était supprimé");
	    }

	    
	    public void updateProduit(Produit p) {
	        produitRepository.save(p);
	        System.err.println("le produit a était modifié");
	    }

}
