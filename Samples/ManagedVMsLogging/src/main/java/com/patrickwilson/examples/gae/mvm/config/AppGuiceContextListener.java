package com.patrickwilson.examples.gae.mvm.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by pwilson on 4/16/15.
 */
public class AppGuiceContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new WebModule());
    }
}
