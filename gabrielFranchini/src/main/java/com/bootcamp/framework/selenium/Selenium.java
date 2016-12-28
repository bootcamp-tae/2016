package com.bootcamp.framework.selenium;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

/**
 * Starts and stops Selenium Server programmatically (Stand Alone mode, not Grid)
 *
 * @author Juan Krzemien
 */
public enum Selenium {

    SERVER;

    private SeleniumServer seleniumServer = new SeleniumServer(new StandaloneConfiguration());

    Selenium() {
        // Turn off verbose logging from Selenium Server...(default is ON)
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.OFF);
        LogManager.getLogManager().getLogger("").setLevel(java.util.logging.Level.OFF);

        // Start Selenium Server programmatically
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
