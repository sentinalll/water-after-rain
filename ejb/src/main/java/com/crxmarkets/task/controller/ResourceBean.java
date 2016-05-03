package com.crxmarkets.task.controller;


import com.crxmarkets.task.algorithm.VolumeOfWaterFinder;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by Roman on 02.05.2016.
 */
@Stateless
public class ResourceBean implements Resource {

    private static final Logger LOGGER = Logger.getLogger(ResourceBean.class);

    @EJB
    VolumeOfWaterFinder volumeOfWaterFinder;

    public Response postSurfaceRelief(int[] relief) {
        LOGGER.debug("postSurfaceRelief method started with relief: " + Arrays.toString(relief));
        Integer count = volumeOfWaterFinder.calculateVolume(relief);
        LOGGER.debug("postSurfaceRelief method ended with count: " + count);
        return Response.ok(count).build();
    }

    public Response getHeartBeat() {
        return Response.ok().build();
    }

}
