package framework.runner;

import framework.logging.Logging;
import framework.server.Selenium;
import framework.web.Browser;
import framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.ParameterizedType;

import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class GenericWebAutomationTest<T extends PageObjectBase> implements Logging {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Selenium.SERVER::stop));
    }

    private T startingPage;

    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    protected T getStartingPage() {
        return startingPage;
    }

    public void setUp(Browser browser) {
        getLogger().debug(format("Creating instance of [%s] with browser [%s]...", getClass().getSimpleName(), browser));
        WebDriver driver = new RemoteWebDriver(browser.getCapabilities());
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
        driver.manage().window().maximize();
        Class<T> pageObjectType = getParameterizedType();
        try {
            this.startingPage = pageObjectType.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            getLogger().error(format("Could not instantiate Page Object [%s]...", pageObjectType.getName()), e);
        }
    }

    public void tearDown() {
        getLogger().debug("Tearing down browser...");
        if (startingPage != null) {
            startingPage.dispose();
        }
    }
}