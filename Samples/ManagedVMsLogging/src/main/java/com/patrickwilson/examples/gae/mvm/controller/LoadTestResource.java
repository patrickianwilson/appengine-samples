package com.patrickwilson.examples.gae.mvm.controller;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
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

    public Random normalRandom = new Random();

    public final LinkedBlockingQueue<Runnable> executorPoolQueue = new LinkedBlockingQueue<Runnable>(1000);

    private ExecutorService pool = new ThreadPoolExecutor(20, 100,
            5, TimeUnit.MINUTES,
            executorPoolQueue,
            Executors.defaultThreadFactory());


    private BackgroundThreadLoggingController backgroundLogger;

    @Inject
    public LoadTestResource(BackgroundThreadLoggingController backgroundLogger) {
        this.backgroundLogger = backgroundLogger;

    }


    public LoadTestResource() {
        LOG.info("constructed LogTestResource controller object.");
    }

    @GET
    @Produces("text/plain")
    public void loadItUp(@Suspended final AsyncResponse response) {
        response.setTimeout(30, TimeUnit.SECONDS);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                double delta = Math.max(((normalRandom.nextGaussian() * 200) + 150), 0); //should give a number between 0 and 1000 - plotted on a normal distribution.
                try {
                    Thread.sleep((long) delta);
                    backgroundLogger.logAsyncronousMessage("Request Completed In: " + (200 + delta) + " ms");
                } catch (InterruptedException e) {
                    LOG.error("Thread Sleep Interrupted!", e);
                    Thread.currentThread().interrupt();
                }
                LOG.info("About To Resume Response");
                response.resume("completed in " + (200 + delta) + " ms");
                LOG.info("Response Resumed!");

            }
        });

    }

    @Path("/queueSize")
    @GET
    @Produces("text/plain")
    public Response getQueueSize() {
        return Response.ok(this.executorPoolQueue.size()).build();
    }

    public LinkedBlockingQueue<Runnable> getExecutorPoolQueue() {
        return executorPoolQueue;
    }


}
