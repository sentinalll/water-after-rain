package com.crxmarketx.task.controller;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Roman on 02.05.2016.
 */

@Local
@Path("/")
@Produces("application/json")
@Consumes("application/json")
public interface Resource {

    @POST
    @Path("/array")
    Integer postArray(String json);

    @GET
    @Path("/books/{isbn}")
    String getBook(@PathParam("isbn") String isbn);
}
