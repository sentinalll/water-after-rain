package com.crxmarkets.controller;


import com.crxmarkets.service.VolumeCalculator;

import org.jboss.logging.Logger;

import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 * Created by Roman on 02.05.2016.
 */
@Stateless
public class ResourceBean implements Resource {

  private static final Logger LOGGER = Logger.getLogger(ResourceBean.class);

  @EJB
  VolumeCalculator volumeCalculator;

  public Response postSurfaceRelief(Integer[] relief) {
    LOGGER.debug("postSurfaceRelief method started with relief: " + Arrays.toString(relief));
    Integer count = volumeCalculator.calculateVolume(Arrays.asList(relief));
    LOGGER.debug("postSurfaceRelief method ended with count: " + count);
    return Response.ok(count).build();
  }

  public Response getHeartBeat() {
    return Response.ok().build();
  }

}
