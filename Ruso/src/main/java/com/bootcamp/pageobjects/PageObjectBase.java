package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * @author Juan Krzemien
 */
abstract class PageObjectBase {

    // Constants
    private static final int TIME_OUT_IN_SECONDS = 60;

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected PageObjectBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        PageFactory.initElements(driver, this);
    }

    // Never allowed to be public!
    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected void click(WebElement element) {
        getWait().until(elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        getWait().until(elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }
}
