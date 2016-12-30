package framework.web;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Abstract class that every Page Object must inherit.
 *
 * @author Juan Krzemien
 */
public abstract class PageObjectBase {

    // Constants
    private static final int TIME_OUT_IN_SECONDS = 60;

    private final WebDriver driver;

    protected PageObjectBase(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
        return new FluentWait<>(object)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withTimeout(timeOutSeconds, SECONDS)
                .pollingEvery(1, SECONDS);
    }

    // Never allowed to be public!
    protected WebDriver getDriver() {
        return driver;
    }

    protected FluentWait<WebDriver> getWait() {
        return waitOn(getDriver(), TIME_OUT_IN_SECONDS);
    }

    protected void click(WebElement element) {
        getWait().until(elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        getWait().until(elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    protected boolean elementExists(WebElement element) {
        try {
            return waitOn(element, 3).until((com.google.common.base.Function<? super WebElement, Boolean>) WebElement::isDisplayed);
        } catch (org.openqa.selenium.TimeoutException toe) {
            return false;
        }
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
