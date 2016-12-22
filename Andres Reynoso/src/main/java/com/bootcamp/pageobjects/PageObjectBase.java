package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Colegio on 21/12/2016.
 */
public abstract class PageObjectBase {

    protected void getWait(WebElement elementId) {
        WebDriverWait getWait = new WebDriverWait(driver, 10);
        getWait.until(ExpectedConditions.elementToBeClickable(elementId));
    }

    protected void type (WebElement elementId,String text){
        getWait(elementId);
        elementId.clear();
        elementId.sendKeys(text);
    }
    
    protected void clic(WebElement elementId) {
        getWait(elementId);
        clic(elementId);
    }



    protected WebDriver driver;


    public PageObjectBase() {
        if (driver ==null){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        };
        PageFactory.initElements(driver, this);
    }

    public PageObjectBase(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}
