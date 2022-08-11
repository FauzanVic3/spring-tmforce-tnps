/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.fauzanvic3.spring.tmforce.tnps.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fauzan
 */
@Service
@Path("/hello")
public class HelloService {
    
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from Spring";
    }
}
