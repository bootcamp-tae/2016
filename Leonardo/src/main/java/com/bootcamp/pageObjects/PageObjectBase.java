package com.bootcamp.pageObjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
abstract class PageObjectBase {

    private WebDriver driver;
    private WebDriverWait wait;

    // SETTER Y GETTER

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    protected void type (WebElement elemento, String txt) {

        getWait().until(ExpectedConditions.elementToBeClickable(elemento));
        ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].focus();", elemento);
        elemento.clear();
        elemento.sendKeys(txt);
        ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].blur();", elemento);
    }

    protected void clickIt (WebElement elemento) {
        getWait().until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.click();

    }


    // CONSTRUCTOR

    public PageObjectBase (WebDriver d) {

        driver = d;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);

    }

}
