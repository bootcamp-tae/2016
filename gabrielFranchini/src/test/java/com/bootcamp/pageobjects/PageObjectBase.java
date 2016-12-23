package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gabriel on 12/21/2016.
 */
//CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO CROTO
public abstract class PageObjectBase  {
    protected WebDriver driver;
    private WebDriverWait wait;

    public PageObjectBase(){

        if (driver==null){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            wait = getWait();

        }
        PageFactory.initElements(driver, this);

    }

    public PageObjectBase(WebDriver d){
        driver = d;
        wait = getWait();
        PageFactory.initElements(driver, this);
    }

    protected void type(WebElement a, String b){
        a.clear();
        a.sendKeys(b);
    }

    protected void click(WebElement a){
        wait.until(ExpectedConditions.elementToBeClickable(a));
        a.click();
    }

    protected WebDriverWait getWait(){
        return new WebDriverWait(driver, 10);
    }

}
