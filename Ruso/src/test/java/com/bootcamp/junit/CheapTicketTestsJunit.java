package com.bootcamp.junit;

import com.bootcamp.framework.junit.WebAutomationJUnitSuite;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultsPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.junit.Test;

/**
 * Day 6 - Practice generic WebDriver instantiation using Selenium server and parameterized tests
 *
 * @author Juan Krzemien
 */
public class CheapTicketTestsJunit extends WebAutomationJUnitSuite<CheapTicketsHome> {

    public CheapTicketTestsJunit(Browser browser) {
        super(browser);
    }

    @Test
    public void flightSearch() {
        CheapTicketsHome home = getStartingPage();

        FlightSearchForm searchForm = home.clickOnFlightTab();

        FlightResultsPage result = searchForm.doSearch("LAS", "LAX", 7, 7);

        result.selectDepartureFlight(6)
                .selectReturnFlight(3)
                .continueBooking();
    }
}
