package poei.orsys2.produit.service;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.stereotype.Component;
import poei.orsys2.produit.entities.Produit;

import java.util.List;


@Component
@WebService(name = "ProduitWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ProduitService {

    @WebMethod
    List<Produit> getProduits();
    @WebMethod
    Produit create(Produit p);
    @WebMethod
    Produit findById(@WebParam(name="id") int id);
    @WebMethod
    void deleteProduit(@WebParam(name="id")int id);
    @WebMethod
    void updateProduit(Produit p);
}
