package com.patrickwilson.examples.gae.mvm.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.Inject;
import com.patrickwilson.examples.gae.mvm.async.BackgroundThreadLoggingController;

/**
 * Created by pwilson on 4/16/15.
 */
@Path("/")
public class LoadTestResource {

    public static final Logger LOG = LoggerFactory.getLogger(LoadTestResource.class);

    private BackgroundThreadLoggingController backgroundLogger;
    @Inject
    public LoadTestResource(BackgroundThreadLoggingController backgroundLogger) {
        this.backgroundLogger = backgroundLogger;
    }

    @GET
    public Response loadItUp() {
        double delta = Math.random() * 10; //should give a number between 0 and 10
        try {
            Thread.sleep(200 + (long)delta);
            backgroundLogger.logAsyncronousMessage("Request Completed In: " + (200 + delta) + " ms");
        } catch (InterruptedException e) {
            LOG.error("Thread Sleep Interrupted!", e);
            Thread.currentThread().interrupt();
        }

        return Response.ok("completed in " + (200 + delta) + " ms").build();
    }

}
