package com.patrickwilson.examples.gae.mvm.config;

import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import com.google.inject.servlet.ServletModule;
import com.patrickwilson.examples.gae.mvm.async.BackgroundThreadLoggingController;
import com.patrickwilson.examples.gae.mvm.controller.AppEngineInternalHandler;
import com.patrickwilson.examples.gae.mvm.controller.LoadTestResource;
import com.patrickwilson.examples.gae.mvm.controller.LoggingResource;

/**
 * Created by pwilson on 4/16/15.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {

        bind(LoggingResource.class).asEagerSingleton();
        bind(LoadTestResource.class).asEagerSingleton();
        bind(AppEngineInternalHandler.class).asEagerSingleton();

        bind(FilterDispatcher.class).asEagerSingleton();

        filter("/*").through(FilterDispatcher.class);
    }
}
