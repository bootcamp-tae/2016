package com.bootcamp.junit;

import com.bootcamp.pageobjects.GoogleHomePage;
import com.bootcamp.pageobjects.GoogleResultsPage;
import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;

/**
 * Day 2 - General WebDriver usage
 * <p>
 * Overview of Page Objects
 * JUnit parameterized tests
 *
 * @author Juan Krzemien
 */

@RunWith(Parameterized.class)
public class SuiteJUnit {

    private WebDriver browser;

    public SuiteJUnit(WebDriver browser) {
        this.browser = browser;
    }

    @Parameters(name = "{index}:Browser[{0}]")
    public static Iterable<Object[]> data() {
        InternetExplorerDriverManager.getInstance().setup(Architecture.x32);
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new InternetExplorerDriver()},
                {new ChromeDriver()}}
        );
    }

    @Before
    public void setUp() {
        browser.manage().window().maximize();
        browser.navigate().to("http://www.google.com");
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        GoogleHomePage home = new GoogleHomePage(browser);
        GoogleResultsPage results = home.doSearch("Something");
        results.clickOnResultNumber(1);
        Thread.sleep(3000);
    }

}
