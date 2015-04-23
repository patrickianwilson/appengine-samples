package com.patrickwilson.examples.gae.mvm.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pwilson on 4/17/15.
 */
public class BackgroundThreadLoggingController {
    public static final Logger LOG = LoggerFactory.getLogger(BackgroundThreadLoggingController.class);

    ExecutorService pool = new ThreadPoolExecutor(2, 4,
            5, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(1000),
            Executors.defaultThreadFactory());


    public BackgroundThreadLoggingController() {

    }

    public void logAsyncronousMessage(final String message) {
        Runnable logTask = new Runnable() {

            @Override
            public void run() {
                LOG.info(message);
            }
        };
        pool.submit(logTask);
    }




}
