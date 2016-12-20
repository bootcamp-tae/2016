package com.bootcamp.junit;

import com.bootcamp.junit.web.pages.GoogleHomePage;
import com.bootcamp.junit.web.pages.GoogleResultsPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

/**
 * Created by Bootcamp on 20/12/2016.
 */

@RunWith(Parameterized.class)
public class SuiteJUnit {

    @Parameters(name = "{index}:Browser[{0}]")
    public static Iterable<Object[]> data() {
        FirefoxDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new FirefoxDriver()},
                {new ChromeDriver()}}
        );
    }

    private WebDriver browser;

    public SuiteJUnit(WebDriver browser) {
        this.browser = browser;
    }

    @Test
    public void test1() throws InterruptedException {
        browser.manage().window().maximize();
        browser.navigate().to("http://www.google.com");

        GoogleHomePage home = new GoogleHomePage(browser);
        GoogleResultsPage results = home.doSearch("Something");
        results.clickOnResultNumber(1);
        Thread.sleep(10000);
        browser.quit();

    }

}
