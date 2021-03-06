package com.patrickwilson.examples.gae.mvm.config;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by pwilson on 4/16/15.
 */
public class AppGuiceContextListener extends GuiceResteasyBootstrapServletContextListener {

    public static final Logger LOG = LoggerFactory.getLogger(AppGuiceContextListener.class);

    protected List<Module> getModules(final ServletContext context) {
        return Lists.<Module>newArrayList(new WebModule());
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
