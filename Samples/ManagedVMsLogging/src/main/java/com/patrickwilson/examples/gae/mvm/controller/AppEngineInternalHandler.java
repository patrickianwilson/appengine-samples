package com.patrickwilson.examples.gae.mvm.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by pwilson on 4/17/15.
 */
@Path("/_ah")
public class AppEngineInternalHandler {

    /**
     * This is called by Appengine once the VM is initialized.
     * @return
     */
    @Path("/start")
    @GET
    @Produces("text/plain")
    public Response start() {
        return Response.ok().build();
    }


    /**
     * This is an opportunity to clean up the VM and submit any cached data that may be lying around.
     * @return
     */
    @Path("/stop")
    @GET
    @Produces("text/plain")
    public Response stop() {
        return Response.ok().build();
    }

    /**
     * Tell App Engine if this instance is still healthy.
     * @return
     */
    @Path("/health")
    @GET
    @Produces("text/plain")
    public Response isHealthy() {
        return Response.ok().build();
    }


    /**
     * "warmup" the instance...
     * @return
     */
    @Path("/warmup")
    @GET
    public Response warmup() {
        return Response.ok().build();
    }

}
