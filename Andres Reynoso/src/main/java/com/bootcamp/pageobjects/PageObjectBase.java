package com.bootcamp.pageobjects;

import com.bootcamp.browser.Browser;
import com.google.common.base.Function;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Colegio on 21/12/2016.
 */
public abstract class PageObjectBase {
    private WebDriverWait wait;

    private final WebDriver driver;

    protected WebDriverWait getWait() {

        return new WebDriverWait(driver, 10);

    }

    protected void untilECC(WebElement elementId){
        //Acronym until, expected,conditions, clickable
        getWait().until(ExpectedConditions.elementToBeClickable(elementId));
    }

    protected void clic(WebElement elementId) {

        untilECC(elementId);
        elementId.click();
    }

    protected void type(WebElement elementId, String text) {

        untilECC(elementId);
        elementId.clear();
        elementId.sendKeys(text);

    }

    protected void untilECV(List<WebElement> elementList) {

        //Acronym until, expected,conditions,visible
        getWait().until(ExpectedConditions.visibilityOfAllElements(elementList));

    }

    protected void clickList(List<WebElement> elementList, int i) {

        untilECV(elementList);
        elementList.get(i).click();

    }

   /*public PageObjectBase() {
        if (driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            wait = getWait();
        };
        PageFactory.initElements(driver, this);
    }*/

    protected PageObjectBase(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    protected WebDriver getDriver() {

        return driver;

    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected boolean exist(WebElement e) {
        try {

            return new FluentWait<>(e)
                    .withTimeout(10, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .pollingEvery(500, TimeUnit.MILLISECONDS)
                    .until((Function<WebElement, Boolean>) WebElement::isDisplayed);

        }catch (TimeoutException tex){

            return false;

        }
    }
}