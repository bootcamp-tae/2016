package com.bootcamp.cucumber.steps;


import com.bootcamp.framework.runner.GenericWebAutomationTest;
import com.bootcamp.framework.web.Browser;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import com.bootcamp.pageobjects.ReviewTrip;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class FlightSearchSteps extends GenericWebAutomationTest<CheapTickets> {

    private FlightSearch form;
    private FlightResult result;
    private ReviewTrip review;

    @Before
    public void setUp() {
        super.setUp(Browser.valueOf(Optional.ofNullable(System.getenv("CUCUMBER_BROWSER")).orElse("CHROME")));
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @Given("^Im on CheapTickets Home Page$")
    public void imOnCheapTicketsHomePage() throws Throwable {
        assertTrue("HomePage Not Visible", getStartingPage().isVisible());
    }

    @And("^I click on Flights Tab$")
    public void iClickOnFlightsTab() throws Throwable {
        form = getStartingPage().clickOnFlightTab();
    }

    @When("^I make a search from \"([^\"]*)\" to \"([^\"]*)\" Departure (\\d+) days and Returning (\\d+) days from today$")
    public void iMakeASearchFromToDepartureDaysAndReturningDaysFromToday(String from, String to, int departure, int returning) throws Throwable {
        result = form.doSearch(from,to,departure,returning);
    }


    @Then("^I see the results page$")
    public void iSeeTheDeparturesPage() throws Throwable {
        assertTrue("Departure flight results page is not visible", result.isVisible());
    }


    @And("^I select the (\\d+) departure flight$")
    public void iSelectTheFlight(int p) throws Throwable {
        result.selectDepartureFlight(2);
    }


    @Then("^I select the (\\d+) returning flight$")
    public void iSelectTheReturningFlight(int p) throws Throwable {
        review = result.selectReturnFlight(p);
    }

    @And("^I see the review page$")
    public void iSeeTheReviewPage() throws Throwable {
        assertTrue("Review page could not be loaded", review.isVisible());
    }

    @Then("^I click the continue booking button$")
    public void iClickTheContinueBookingButton() throws Throwable {
        review.continueBooking();
    }
}
