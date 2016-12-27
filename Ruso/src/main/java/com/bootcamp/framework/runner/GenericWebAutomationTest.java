package com.bootcamp.framework.runner;

import com.bootcamp.framework.selenium.Selenium;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.ParameterizedType;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Juan Krzemien
 */
public class GenericWebAutomationTest<T extends PageObjectBase> {

    private static final ThreadLocal<PageObjectBase> STARTING_PAGE = new ThreadLocal<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Selenium.SERVER::stop));
    }

    private final Browser browser;

    public GenericWebAutomationTest(Browser browser) {
        System.out.println("Creating " + getClass().getSimpleName() + " instance with browser " + browser);
        this.browser = browser;
    }

    /**
     * Calculates the value of parameter type "T" of this WebAutomationJUnitSuite instance.
     * <p>
     * Uses reflection to do so.
     *
     * @return parameter type "T" of this WebAutomationJUnitSuite instance
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getParameterizedType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    protected T getStartingPage() {
        return (T) STARTING_PAGE.get();
    }

    public void setUp() {
        // Create the driver to inject into Page Object...
        WebDriver driver = new RemoteWebDriver(browser.getCapabilities());
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
        driver.manage().window().maximize();

        // Instantiate Page Object calculated from parameterized type...
        // This is equal to: new PageObjectType(driver);
        try {
            STARTING_PAGE.set(getParameterizedType().getConstructor(WebDriver.class).newInstance(driver));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * This way, we do not expose WebDriver instance to tests.
         * We provide them with the first Page Object they need already initialized.
         */
    }

    public void tearDown() {
        T page = getStartingPage();
        if (page != null) {
            page.dispose();
        }
    }

}
