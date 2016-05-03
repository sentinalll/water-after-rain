package com.crxmarkets.task.controller;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Roman on 02.05.2016.
 */

@Local
@Path("/")
@Produces("application/json")
@Consumes("application/json")
public interface Resource {

    @POST
    @Path("/surface")
    Response postSurfaceRelief(int[] relief);

    @GET
    @Path("/heartbeat")
    Response getHeartBeat();
}
