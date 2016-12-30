package framework.web;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Enumeration defining which browsers we support/work on.
 *
 * At the same time, we are adding the capabilities of each browser to its definition.
 *
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
    /*FIREFOX {
        @Override
        public Capabilities getCapabilities() {
            FirefoxDriverManager.getInstance().setup();
            return DesiredCapabilities.firefox();
        }
    },*/
    IE {
        @Override
        public Capabilities getCapabilities() {
            InternetExplorerDriverManager.getInstance().setup();
            return DesiredCapabilities.internetExplorer();
        }
    };

    public abstract Capabilities getCapabilities();

}
