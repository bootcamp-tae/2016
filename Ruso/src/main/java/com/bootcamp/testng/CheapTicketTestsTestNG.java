package com.bootcamp.testng;

import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultsPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Day 3 - Practice Page Objects creation
 * <p>
 * At this moment, we do not *really* care about having
 * web driver instances being created in the test.
 *
 * @author Juan Krzemien
 */
public class CheapTicketTestsTestNG {

    private WebDriver driver;

    public CheapTicketTestsTestNG() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void flightSearch() {
        CheapTicketsHome home = new CheapTicketsHome(driver);

        FlightSearchForm searchForm = home.clickOnFlightTab();

        FlightResultsPage result = searchForm.doSearch("LAS", "LAX", 7, 7);

        result.selectFlight(4);
    }
}
