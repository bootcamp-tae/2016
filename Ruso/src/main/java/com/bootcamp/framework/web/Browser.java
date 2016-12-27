package com.bootcamp.framework.web;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Juan Krzemien
 */
public enum Browser {

    CHROME {
        @Override
        public Capabilities getCapabilities() {
            ChromeDriverManager.getInstance().setup();
            return DesiredCapabilities.chrome();
        }
    },
    FIREFOX {
        @Override
        public Capabilities getCapabilities() {
            FirefoxDriverManager.getInstance().setup();
            return DesiredCapabilities.firefox();
        }
    },
    IE {
        @Override
        public Capabilities getCapabilities() {
            InternetExplorerDriverManager.getInstance().setup(Architecture.x32);
            return DesiredCapabilities.internetExplorer();
        }
    };

    public abstract Capabilities getCapabilities();

}
