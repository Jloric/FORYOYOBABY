package poei.orsys2.produit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;


@Configuration
public class MyConfig {
    @Bean
    SimpleJaxWsServiceExporter serviceExporter(){
        System.err.println("Starting SimpleJaxWsServiceExporter");
        SimpleJaxWsServiceExporter serviceExport = new SimpleJaxWsServiceExporter();
        serviceExport.setBaseAddress("http://localhost:8085");
        System.err.println("WSDL available on  http://localhost:8085/ProduitWS?wsdl");
        return serviceExport;
    }
}
