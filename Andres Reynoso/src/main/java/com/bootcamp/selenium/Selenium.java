package com.bootcamp.selenium;

import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

/**
 * Created by Colegio on 28/12/2016.
 */
public enum Selenium {
    SERVER;

    private SeleniumServer seleniumServer = new SeleniumServer(new StandaloneConfiguration());

    Selenium() {
        try {
            seleniumServer.boot();
        }
        catch (RuntimeException error) {
            //Already Running
        }
    }

    public void stopServer() {
        try {
            seleniumServer.stop();
        }
        catch (RuntimeException error) {
            //Turning Off Server
        }
    }
}
