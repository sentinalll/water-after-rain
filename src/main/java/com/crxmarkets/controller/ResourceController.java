package com.crxmarkets.controller;


import com.crxmarkets.service.VolumeCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This controller performs communication between Web and volume calculation services.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ResourceController {

    private static final Logger LOGGER = LogManager.getLogger(ResourceController.class);

    @EJB
    VolumeCalculator volumeCalculator;

    @POST
    @Path("/surface")
    public Response postSurfaceRelief(RequestDTO dto) {
        LOGGER.debug("postSurfaceRelief method started with surface relief: " + dto);
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
