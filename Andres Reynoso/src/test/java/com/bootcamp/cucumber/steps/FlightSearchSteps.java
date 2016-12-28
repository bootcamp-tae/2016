package com.bootcamp.cucumber.steps;

import com.bootcamp.browser.Browser;
import com.bootcamp.junit.WASuitJUNit;
import com.bootcamp.pageobjects.CheapTicketHome;
import com.bootcamp.pageobjects.FlightResultPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by Colegio on 28/12/2016.
 */
public class FlightSearchSteps extends WASuitJUNit <CheapTicketHome> {
    @Given("^I am on cheaptickets homepage$")
    public void CheapTicketHome() throws Throwable {
        CheapTicketHome home = getPage();
        home.clickOnFlightTab();

        // Write code here that turns the phrase above into concrete actions

    }

    //@And("^I clickOnFlightTab$")
    /*public void iClickOnFlightTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions


    }*/
}
