package com.patrickwilson.examples.gae.mvm.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    public Response start() {
        return Response.ok().build();
    }


    /**
     * This is an opportunity to clean up the VM and submit any cached data that may be lying around.
     * @return
     */
    @Path("/stop")
    @GET
    public Response stop() {
        return Response.ok().build();
    }

    /**
     * Tell App Engine if this instance is still healthy.
     * @return
     */
    @Path("/health")
    @GET
    public Response isHealthy() {
        return Response.ok().build();
    }
}
