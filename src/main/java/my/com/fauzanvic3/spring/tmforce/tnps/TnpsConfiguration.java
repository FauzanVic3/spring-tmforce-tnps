/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import my.com.fauzanvic3.spring.tmforce.tnps.service.HelloService;
import my.com.fauzanvic3.spring.tmforce.tnps.service.TnpsService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Fauzan
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class TnpsConfiguration extends ResourceConfig{
        
    private String serviceId;
    private String serviceName;
    private Map modelEndpoints;
    boolean corsEnabled = true;
    
    public TnpsConfiguration(){
        register(TnpsService.class);
        register(HelloService.class);                
    }
    
    @JsonProperty
    public String getServiceName() {
        return serviceName;
    }
    
    @JsonProperty
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    @JsonProperty
    public String getServiceId() {
        return serviceId;
    }
    
    @JsonProperty
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Map getModelEndpoints() {
        return modelEndpoints;
    }

    public void setModelEndpoints(Map modelEndpoints) {
        this.modelEndpoints = modelEndpoints;
    }

    public boolean isCorsEnabled() {
        return corsEnabled;
    }

    public void setCorsEnabled(boolean corsEnabled) {
        this.corsEnabled = corsEnabled;
    }
    
    
}
