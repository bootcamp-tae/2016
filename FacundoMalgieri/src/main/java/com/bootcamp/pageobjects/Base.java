package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

abstract public class Base {
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

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }
}
