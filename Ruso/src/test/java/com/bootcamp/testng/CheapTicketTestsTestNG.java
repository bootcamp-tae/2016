package com.bootcamp.testng;

import com.bootcamp.framework.testng.WebAutomationTestNGSuite;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultsPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Day 6 - Practice generic WebDriver instantiation using Selenium server and parameterized tests
 *
 * @author Juan Krzemien
 */
public class CheapTicketTestsTestNG extends WebAutomationTestNGSuite<CheapTicketsHome> {

    @Factory(dataProvider = "browsers")
    public CheapTicketTestsTestNG(Browser browser) {
        super(browser);
    }

    @Test(threadPoolSize = 5)
    public void flightSearch() {
        CheapTicketsHome home = getStartingPage();

        FlightSearchForm searchForm = home.clickOnFlightTab();

        FlightResultsPage result = searchForm.doSearch("LAS", "LAX", 7, 7);

        result.selectDepartureFlight(6)
                .selectReturnFlight(3)
                .continueBooking();
    }
}
