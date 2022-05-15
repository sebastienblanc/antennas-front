package org.sebi.incident;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081")
public interface IncidentService {
    
    @GET
    @Path("rest/incidents")
    public List<Incident> getAll(@QueryParam("api_key") String apiKey);
}
