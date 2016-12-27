package com.bootcamp.framework.web;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

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
        PageFactory.initElements(driver, this);
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
            return waitOn(element, 3).until((Function<? super WebElement, Boolean>) WebElement::isDisplayed);
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
