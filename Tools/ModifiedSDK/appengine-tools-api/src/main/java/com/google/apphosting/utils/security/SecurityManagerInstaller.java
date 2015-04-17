package com.google.apphosting.utils.security;

import java.net.URL;

public class SecurityManagerInstaller {

    public static void install(boolean something, URL[] urls) {
        //no security manager for the managed VM runtime environment.
        System.out.println("Skip install SecurityManager");
    }

}