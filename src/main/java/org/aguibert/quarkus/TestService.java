package org.aguibert.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/people")
public class TestService {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person find() {
        return Person.findAll().firstResult();
    }
    
    @GET
    @Path("str")
    public String findStr() {
//        return Response.ok().entity(Person.findAll().firstResult().toString()).build();
        return Person.findAll().firstResult().toString();
    }

}
