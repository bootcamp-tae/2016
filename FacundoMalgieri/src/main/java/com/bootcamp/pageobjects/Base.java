package com.bootcamp.pageobjects;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

abstract class Base {
    private WebDriver driver;
    private WebDriverWait wait;

    public Base() {
        if(driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            wait   = new WebDriverWait(driver,30);
        }
        PageFactory.initElements(driver,this);
    }

    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(this.driver,30);
    }

    protected void type (WebElement element, String str) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(str);
    }

    protected void click (WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected boolean exists(WebElement e) {
        try {
            return new FluentWait<>(e)
                    .withTimeout(5, SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until((Function<WebElement, Boolean>) WebElement::isDisplayed);
        }catch (TimeoutException err){
            return false;
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }
}
