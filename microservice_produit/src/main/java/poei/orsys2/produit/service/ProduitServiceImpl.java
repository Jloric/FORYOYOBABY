package poei.orsys2.produit.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import poei.orsys2.produit.dao.ProduitRepository;
import poei.orsys2.produit.entities.Produit;

import java.util.List;

@WebService
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
        System.out.println("voici le porduit demander:");
        System.err.println(p);
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
