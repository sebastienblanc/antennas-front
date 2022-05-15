package org.sebi.incident;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("rest/incidents")
public class IncidentResource {

    @ConfigProperty(name = "apikey")
    String apiKey;

    @RestClient
    IncidentService service;
    
    @GET
    @Fallback(fallbackMethod = "fallback")
    public List<Incident> getIncidents(){
       return service.getAll(apiKey);
    } 

    private List<Incident> fallback(){
        Incident incident = new Incident();
        incident.id = 1;
        incident.date = new Date();
        incident.description = "fallback";
        incident.status = false;
        return Collections.singletonList(incident);
    }
}
