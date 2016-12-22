package com.bootcamp.pageObjects;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
abstract class PageObjectBase {

    protected WebDriver driver;

    public PageObjectBase () {

        if (driver == null) {

            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }

        PageFactory.initElements(driver, this);


    }

    public PageObjectBase (WebDriver d) {

        driver = d;
        PageFactory.initElements(driver, this);

    }

}
