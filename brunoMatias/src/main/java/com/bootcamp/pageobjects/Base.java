package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class Base {
    protected WebDriver driver;
    private WebDriverWait wait;

    public Base() {
        if(driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            wait = getWait();
        }
        PageFactory.initElements(driver,this);
    }

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = getWait();
        PageFactory.initElements(driver,this);

    }

    protected WebDriverWait getWait(){
        return new WebDriverWait(driver, 10);
    }

    protected void Type(WebElement element, String string){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(string);
    }

    protected void Click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
