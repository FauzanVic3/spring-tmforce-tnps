/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps;

import java.util.Iterator;
import java.util.Map;
import my.com.fauzanvic3.spring.tmforce.tnps.TnpsConstant.API;
import my.com.fauzanvic3.spring.tmforce.tnps.service.TnpsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.expression.EnvironmentAccessor;

/**
 *
 * @author Fauzan
 */
@SpringBootApplication
public class TnpsMain implements CommandLineRunner{

    @Autowired
    private TnpsConfiguration config;

    private final Logger log = LoggerFactory.getLogger(getClass().getName());
        
    public static void main(String[] args) throws Exception{
        SpringApplication.run(TnpsMain.class,args);
    }
    
    @Override
    public void run(String... args) throws Exception {
                
        if(config.getModelEndpoints() != null && !config.getModelEndpoints().isEmpty()){
            Map mapUrl = config.getModelEndpoints();
            Iterator<Map.Entry<String, String>> itr = mapUrl.entrySet().iterator();
            while(itr.hasNext()){
                Map.Entry<String, String> entry = itr.next();
                switch(entry.getKey()){
                    case "urlTnpsReceiver": API.urlTnpsReceiver = entry.getValue(); 
                        log.info(entry.getValue());
                    break;
                    default:
                }
            }
        }
    }

    
//    @Override
//    public void initialize(Bootstrap<TnpsConfiguration> bootstrap) {
//        bootstrap.addBundle(new AssetsBundle("/info", "/", "version.txt", "static"));
//        //make api-docs path configurable
//        String apiDocsPath = System.getenv("TMF_SWAG_APIDOCS_PATH");
//        if (apiDocsPath == null) {
//            apiDocsPath = "/eai/spice/api-docs";
//        }
//        log.info("apiDocsPath = " + apiDocsPath);
//        
//        bootstrap.addBundle(new AssetsBundle("/api-docs", apiDocsPath));        
//        bootstrap.setConfigurationSourceProvider(
//                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
//                        new EnvironmentVariableSubstitutor(false)
//                )
//        );
//    }
//    
//    @Override
//    public void run(TnpsConfiguration config, Environment environment) throws Exception {
//
//        environment.jersey().register(MultiPartFeature.class);
//        
//        if (config.getSwagger() != null) {
//            new ForceSwaggerBeanUtil().initializeSwagger(config.getSwagger(), config, environment);
//            environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            environment.jersey().register(new TnpsSwaggerUIResource(config.getSwagger()));
//            environment.jersey().register(new TnpsApiListingResource());
//        }
//
//        
//        TnpsService service = new TnpsService();
//        environment.jersey().register(service);
//    }

    
    
}
