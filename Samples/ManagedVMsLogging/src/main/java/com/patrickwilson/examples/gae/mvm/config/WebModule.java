package com.patrickwilson.examples.gae.mvm.config;

import com.google.inject.servlet.ServletModule;
import com.patrickwilson.examples.gae.mvm.async.BackgroundThreadLoggingController;
import com.patrickwilson.examples.gae.mvm.controller.AppEngineInternalHandler;
import com.patrickwilson.examples.gae.mvm.controller.LoadTestResource;
import com.patrickwilson.examples.gae.mvm.controller.LoggingResource;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Created by pwilson on 4/16/15.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        binder().bind(LoggingResource.class);

        binder().bind(LoadTestResource.class);
        binder().bind(AppEngineInternalHandler.class);

        binder().bind(BackgroundThreadLoggingController.class).asEagerSingleton();;

        serve("/*").with(GuiceContainer.class);//, ImmutableMap.of(ResourceConfig.FEATURE_DISABLE_WADL, true));
    }
}
