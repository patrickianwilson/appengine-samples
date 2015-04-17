package com.patrickwilson.examples.gae.mvm.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pwilson on 4/17/15.
 */
public class BackgroundThreadLoggingController {
    public static final Logger LOG = LoggerFactory.getLogger(BackgroundThreadLoggingController.class);
    ExecutorService pool = Executors.newFixedThreadPool(2);
    BackgoundTask task = new BackgoundTask();


    public BackgroundThreadLoggingController() {
        startBackgroundThread();
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


    public void startBackgroundThread() {
        task.running = true;
        task.start();
    }

    public class BackgoundTask extends Thread {

        public final Logger LOG = LoggerFactory.getLogger(BackgoundTask.class);
        private boolean running = true;

        @Override
        public synchronized void run() {

            while (running) {
                LOG.info("BackgroundTask Executed!");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    LOG.error("Task Interrupted!", e);
                    Thread.currentThread().interrupt();
                }
            }
        }


    }

}
