package com.patrickwilson.examples.gae.mvm.config;

import com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;
import com.patrickwilson.examples.gae.mvm.controller.IndexResource;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Created by pwilson on 4/16/15.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        binder().bind(IndexResource.class);
        serve("/*").with(GuiceContainer.class);//, ImmutableMap.of(ResourceConfig.FEATURE_DISABLE_WADL, true));
    }
}
