package com.patrickwilson.examples.gae.mvm.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by pwilson on 4/16/15.
 */
@Path("/log")
public class LoggingResource {

    public static final Logger LOG = LoggerFactory.getLogger(LoggingResource.class);

    @GET
    @Produces("text/plain")
    public Response showIndexPage() {
        LOG.debug("Issuing a DEBUG log event");
        LOG.info("Issuing a INFO log event");
        LOG.warn("Issuing a WARNING log event");
        LOG.error("Issuing an ERROR log event");
        return Response.ok("Hello World").build();
    }
}
