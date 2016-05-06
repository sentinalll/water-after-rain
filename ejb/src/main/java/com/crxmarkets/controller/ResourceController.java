package com.crxmarkets.controller;


import com.crxmarkets.service.VolumeCalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@Produces("application/json")
@Consumes("application/json")
public class ResourceController {

  private static final Logger LOGGER = LogManager.getLogger(ResourceController.class);

  @EJB
  VolumeCalculator volumeCalculator;

  @POST
  @Path("/surface")
  public Response postSurfaceRelief(RequestDTO dto) {
    LOGGER.debug("postSurfaceRelief method started with relief: " + dto);
    Integer count = volumeCalculator.calculateVolume(dto.getList());
    LOGGER.debug("postSurfaceRelief method ended with count: " + count);
    return Response.ok(count).build();
  }

  @GET
  @Path("/heartbeat")
  public Response getHeartBeat() {
    return Response.ok().build();
  }

}
