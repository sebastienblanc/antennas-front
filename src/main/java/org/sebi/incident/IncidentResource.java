package org.sebi.incident;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("rest/incidents")
public class IncidentResource {

    @ConfigProperty(name = "apikey")
    String apiKey;

    @RestClient
    IncidentService service;
    
    @GET
    public List<Incident> getIncidents(){
       return service.getAll(apiKey);
    } 
}
