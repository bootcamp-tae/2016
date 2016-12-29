package com.bootcamp.cucumber.steps;

import com.bootcamp.pageobjects.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightSearchSteps {

    @Given("^I am on the CheapTickets Home Page$")
    public void goToHomePage(){
        //if
        assertTrue("CheapTickets isn't visible", getStartingPage().isVisible());

    }

    @And("^I click on the Flights Tab$")
    public void clickOnFlightTab(){
        cheapTicketHomePage.clickOnFligthTab();
    }

    @When("^I perform a Flight Search with the argument \"([^\"]*)\" in origin and the argument \"([^\"]*)\" in destination for (\\d+) days from today and returning (\\d+) days afterwards$")
    public void FlightSearch(String arg0, String arg1, int arg2, int arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I should see a results page with a button to continue$")
    public void PageToContinue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
