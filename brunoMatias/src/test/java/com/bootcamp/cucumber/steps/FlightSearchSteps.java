package com.bootcamp.cucumber.steps;

import com.bootcamp.pageobjects.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightSearchSteps {

    private FlightSearch form;
    private FlightResult results;

    @Given("^I am on the CheapTickets Home Page$")
    public void goToHomePage(){
        assertTrue("CheapTickets is not visible", getStartingPage().isVisible());
    }

    @And("^I click on the Flights Tab$")
    public void clickOnFlightTab(){
        form = cheapTicketHomePage.clickOnFligthTab();
    }

    @When("^I perform a Flight Search with the argument \"([^\"]*)\" in origin and the argument \"([^\"]*)\" in destination for (\\d+) days from today and returning (\\d+) days afterwards$")
    public void flightDoSearch(String arg1, String arg2, int arg3, int arg4) throws Throwable {
        results = form.doSearch(arg1,arg2,arg3,arg4);
    }

    @Then("^I should see a results page with a button to continue$")
    public void continuePage() throws Throwable {
        assertTrue("Results page is not visible", result.isVisible());
    }

    @And("^I select the (\\d+) departure flight and the (\\d+) returning flight$")
    public void selectFlight(int f) throws Throwable {
        result.departureFlight(2).returnFlight(4);
    }


}
