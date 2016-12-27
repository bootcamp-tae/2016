package com.bootcamp.junit;

import com.bootcamp.browser.Browser;
import com.bootcamp.pageobjects.PageObjectBase;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Colegio on 27/12/2016.
 */

@RunWith(Parameterized.class)
public abstract class WASuitJUNit extends PageObjectBase {

    @Parameterized.Parameter
    public Browser currentBrowser;

    /*@Parameterized.Parameters(name = "Browser[0]")
    public static Set<Browser> getBrowser() {
        return Arrays.stream(Browser.values()).collect(Collectors.toSet());
    }*/
    private WebDriver browser;

    public WASuitJUNit(WebDriver browser) {
        super(browser);
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{index} : Browser[{0}]")
    public static Iterator<Object[]> data() {

        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
        InternetExplorerDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new Firefox()},
                {new InternetExplorer()},
                {new ChromeDriver()}}
        );
    }

    public void setUp() {
        driver.navigate().to("https://www.cheaptickets.com");
        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.quit();
    }
}




    /*@Before
    public void setUp(){
       super.setUp();

    }
    @After
    public void tearDown() {
        super.tearDown();
    }*/


