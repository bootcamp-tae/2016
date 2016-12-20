package com.bootcamp.junit.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Bootcamp on 20/12/2016.
 */
abstract class PageObjectBase {

    private final WebDriver browser;
    private final WebDriverWait wait;

    public PageObjectBase(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, 10);
        PageFactory.initElements(browser, this);
    }

    protected WebDriver getBrowser() {
        return browser;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

}
