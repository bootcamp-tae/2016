package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Colegio on 21/12/2016.
 */
public abstract class PageObjectBase {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int TIME_OUT_IN_SECONDS = 60;

    public PageObjectBase() {
        if (driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    }

    public PageObjectBase(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

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
        getWait().until(elementToBeClickable(element)).clear();
        element.sendKeys(text);
    }
}
