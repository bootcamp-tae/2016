package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SuiteJUnit {
    private WebDriver browser;

    public SuiteJUnit (WebDriver browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{}:[{0}]")
    public static Collection<Object[]> data() {
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new ChromeDriver()},
        });
    }

    @Before
    //this method maximize the window and browse to the chosen page
    public void BeforeEach () {
        browser.manage().window().maximize();
        browser.navigate().to("http://www.cheaptickets.com");
    }

    @After
    //this method finish the driver after each test
    public void AfterEach () {
        browser.quit();
    }

    @Test
    //this test open the CT page, clicks on the Flight Tab, completes the form with chosen data and finishes the operation
    //IT'S AMAZING!
    public void FlightSearch() {
        CheapTickets home = new CheapTickets();
        FlightSearch form = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 7);
        result.selectFlight(4).selectFlight(2);
    }


}
