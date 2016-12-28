package com.bootcamp.cucumber.definitions;

import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultsPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * @author Juan Krzemien
 */
public class FlightSearchSteps extends GenericWebAutomationTest<CheapTicketsHome> {

    private FlightSearchForm searchFormPage;
    private FlightResultsPage resultsPage;

    @Before
    public void setUp() {
        // If there is time...maybe deploy a CI server and show build usages with env vars?
        super.setUp(Browser.valueOf(Optional.ofNullable(System.getenv("CUCUMBER_BROWSER")).orElse("CHROME")));
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("^I am at CheapTickets home page$")
    public void iAmAtCheapTicketsHomePage() throws Throwable {
        assertTrue("CheapTickets home page is not visible", getStartingPage().isVisible());
    }

    @And("^I click on Flights tab$")
    public void iClickOnFlightsTab() throws Throwable {
        searchFormPage = getStartingPage().clickOnFlightTab();
    }

    @When("^I perform a flight search from \"([^\"]*)\" to \"([^\"]*)\" for (\\d+) days from today and returning (\\d+) days afterwards$")
    public void iPerformAFlightSearchFromToForDaysFromTodayAndReturningDaysAfterwards(String from, String to, int departureDays, int returnDays) throws Throwable {
        resultsPage = searchFormPage.doSearch(from, to, departureDays, returnDays);
    }

    @Then("^I should see a the departure flight results page$")
    public void iShouldSeeATheDepartureFlightResultsPage() throws Throwable {
        assertTrue("Departure flight results page is not visible", resultsPage.isVisible());
    }

}
