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
        FirefoxDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new ChromeDriver()},
                {new FirefoxDriver()}

        });
    }

    @Before
    public void start () {
        browser.navigate().to("http://www.cheaptickets.com");
    }

    @After
    public void finish () {
        browser.quit();
    }

    @Test
    public void FlightSearch() {

        CheapTickets home   = new CheapTickets();
        FlightSearch form   = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 7);
        result.selectFlight(4)
                .selectFlight(2);
    }


}
