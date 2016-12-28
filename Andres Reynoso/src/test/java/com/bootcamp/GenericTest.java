package com.bootcamp;

import com.bootcamp.browser.Browser;
import com.bootcamp.pageobjects.PageObjectBase;
import com.bootcamp.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Colegio on 28/12/2016.
 */
public abstract class GenericTest <T extends PageObjectBase>{
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> Selenium.SERVER.stopServer()));
    }

    private T page;

    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    protected T getPage() {
        return page;
    }

    public void setUp(Browser browser) {
        WebDriver driver = new RemoteWebDriver(browser.getCapabilities());
        driver.manage().window().maximize();

        Class<T> pageObjectType = getParameterizedType();
        try {
            this.page = pageObjectType.getConstructor(WebDriver.class).newInstance(driver);
        }
        catch (Exception ex) {
            //nothing
        }
    }

    public void tearDown() {
        if (page != null) {
            page.closeDriver();
        }
    }

}
