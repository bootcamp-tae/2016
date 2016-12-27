package com.bootcamp.browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Colegio on 27/12/2016.
 */
public enum Browser {
    GOOGLECHROME {
        @Override
        public Capabilities getCapabilities() {
            ChromeDriverManager.getInstance().setup();
            return DesiredCapabilities.chrome();
        }
    },

    INTERNETEXPLORER {
        @Override
        public Capabilities getCapabilities() {
            InternetExplorerDriverManager.getInstance().setup();
            return DesiredCapabilities.internetExplorer();
        }
    },

    EDGE {
        @Override
        public Capabilities getCapabilities() {
            EdgeDriverManager.getInstance().setup();
            return DesiredCapabilities.edge();
        }

    },

    FIREFOX {
        @Override
        public Capabilities getCapabilities() {
            FirefoxDriverManager.getInstance().setup();
            return DesiredCapabilities.firefox();
        }
    };

    public abstract Capabilities getCapabilities();
}
