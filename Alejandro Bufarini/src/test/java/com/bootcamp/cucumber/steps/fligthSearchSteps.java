package com.bootcamp.cucumber.steps;

import com.bootcamp.pageobjects.CheapTicketHomePage;
import com.bootcamp.pageobjects.PageObjectBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by Colegio on 28/12/2016.
 */
public class fligthSearchSteps extends PageObjectBase {
    CheapTicketHomePage cheapTicketHomePage;

    @Given("^ Im in homepage cheaptickeckts$")
    public void isInCheapTicketHomePage() throws Throwable {
       assertTrue(getDriver().getCurrentUrl().equals("https://www.cheaptickets.com"));
    }

    @And("^I click on fligth tab$")
    public void clickFligthTab() throws  Throwable {
        cheapTicketHomePage.clickOnFligthTab();
    }

    @When("^I complete the fields \"(origins)\",\"(destiny)\",\"(departure date)\" and \"(arrive day)\" and search fligths$")
    public doSearch(o,d,d,a){
        
    }
}
