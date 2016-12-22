package com.bootcamp.pageObjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
abstract class PageObjectBase {

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

    private WebDriver driver;
    private WebDriverWait wait;

    protected void type (WebElement elemento, String txt) {

        getWait().until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.clear();
        elemento.sendKeys(txt);

    }

    protected void clickIt (WebElement elemento) {

        getWait().until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.click();

    }

    public PageObjectBase () {

        if (driver == null) {

            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }

        PageFactory.initElements(driver, this);
        // espera como maximo x tiempo
        wait = new WebDriverWait(driver, 20);

    }

    public PageObjectBase (WebDriver d) {

        driver = d;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);

    }

}
