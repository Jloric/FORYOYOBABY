package poei.orsys2.produit.service;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;

import java.util.List;
import java.util.Optional;

@WebService(endpointInterface = "com.orsys.ws.server.soap.ProduitService")
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Produit> getProduits() {
        System.err.println("Voici la liste des produits");
        return produitRepository.findAll();
    }


    @Override
    public Produit create(Produit p) {
        produitRepository.save(p);
        System.err.println("le produit a était crée");
        return p;
    }

    @Override
    public Produit findById(@WebParam(name="id") int id){
        Produit p=produitRepository.findById(id).get();
        return p;
    }

    @Override
    public void deleteProduit(@WebParam(name="id")int id) {
        produitRepository.deleteById(id);
        System.err.println("le produit a était supprimé");
    }

    @Override
    public void updateProduit(Produit p) {
        produitRepository.save(p);
        System.err.println("le produit a était modifié");
    }

}
