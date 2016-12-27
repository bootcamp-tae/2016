package com.bootcamp.framework.selenium;

import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

/**
 * Created by Colegio on 27/12/2016.
 */
public enum Selenium {

    SERVER;

    private SeleniumServer seleniumServer = new SeleniumServer(new StandaloneConfiguration());

    Selenium() {
        try {
            seleniumServer.boot();
        } catch (RuntimeException re) {
            System.out.println("Selenum Server already running. Reusing...");
        }
    }

    public void stop() {
        // Stop Selenium server
        try {
            seleniumServer.stop();
        } catch (RuntimeException rte) {
            // Do nothing: Shutdown in progress
        }
    }
}
