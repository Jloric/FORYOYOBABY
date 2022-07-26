package poei.orsys2.produit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import poei.orsys2.produit.service.ProduitServiceImpl;

import javax.xml.ws.Endpoint;


@Configuration
public class MyConfig {
    @Bean
    SimpleJaxWsServiceExporter serviceExporter(){
        System.err.println("Starting SimpleJaxWsServiceExporter");
        SimpleJaxWsServiceExporter serviceExport = new SimpleJaxWsServiceExporter();
        Endpoint endpoint =Endpoint.create(new ProduitServiceImpl());
        endpoint.publish("http://localhost:8085/ProduitWS");
        serviceExport.publishEndpoints();
        //serviceExport.setBaseAddress("http://localhost:8085");
        System.err.println("WSDL available on  http://localhost:8085/ProduitWS?wsdl");
        return serviceExport;
    }
}
