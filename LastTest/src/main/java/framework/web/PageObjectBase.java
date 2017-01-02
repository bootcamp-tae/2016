package framework.web;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

abstract public class PageObjectBase {

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

    protected boolean exists(WebElement element) {
        try {
            getWait().withTimeout(3, SECONDS).until(visibilityOf(element));
            return true;
        } catch (TimeoutException toe) {
            return false;
        }
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
