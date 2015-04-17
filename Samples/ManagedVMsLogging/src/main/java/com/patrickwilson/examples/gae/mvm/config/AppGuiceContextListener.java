package com.patrickwilson.examples.gae.mvm.config;

import javax.servlet.ServletContextEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by pwilson on 4/16/15.
 */
public class AppGuiceContextListener extends GuiceServletContextListener {

    public static final Logger LOG = LoggerFactory.getLogger(AppGuiceContextListener.class);

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new WebModule());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            super.contextInitialized(servletContextEvent);
            LOG.info("Context Initialized!.  This is out of request thread.");
        } catch (Throwable t) {
            LOG.error("Unable to start context!", t);
            throw new RuntimeException(t);
        }
    }
}
