package com.bootcamp.pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class Base {
    protected WebDriver driver;

    public Base() {
        if(driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver,this);
    }

    public Base(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
}
