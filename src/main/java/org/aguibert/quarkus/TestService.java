package org.aguibert.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TestService {

    @Inject
    EntityManager em;

    @GET
    @Transactional
    public Gift hello() {
        Gift gift = new Gift();
        gift.setName("New gift");
        em.persist(gift);
        return gift;
    }

    @GET
    @Path("/list")
    public List<Gift> getAll() {
        TypedQuery<Gift> query = em.createNamedQuery("Gifts.findAll", Gift.class);
        return query.getResultList();
    }

}
