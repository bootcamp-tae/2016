package com.bootcamp.junit;

import com.bootcamp.GenericTest;
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
public abstract class WASuitJUNit<T extends PageObjectBase> extends GenericTest<T> {

    @Parameterized.Parameter
    public Browser currentBrowser;

    public static Set<Browser> getBrowsers() {

        return Arrays.stream(Browser.values()).collect(Collectors.toSet());

    }

    @Before
    public void setUp() {

        super.setUp(currentBrowser);

    }

    public void tearDown() {

        super.tearDown();

    }

    /*public WASuitJunit(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Parameterized.Parameters(name = "{index} : Browser[{0}]")
    public static Collection<Object[]> data() {
        ChromeDriverManager.getInstance().setup();
        //FirefoxDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                //{new Firefox()},
                //{new InternetExplorer()},
                {new ChromeDriver()}}
        );
    }
    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to(CHEAPTICKETS_URL);
    }
    @After
    public void tearDown() {
        driver.quit();
    }*/
}



