package com.crxmarkets.controller;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
  Response postSurfaceRelief(Integer[] relief);

  @GET
  @Path("/heartbeat")
  Response getHeartBeat();
}
