package com.bootcamp.Cucumber.Steps;

import PageObjets.FlightResultPage;
import PageObjets.FlightSearchForm;
import cucumber.api.java.en.Given;
import org.junit.Assert;

/**
 * Created by Colegio on 28/12/2016.
 */
public class FlightSearchStep {

    private FlightResultPage resultPage;
    private FlightSearchForm searchForm;


    @Given("^I am at cheapticket's home page$")
    public void imAtCheapTicketsHomePage() throws Throwable {
        Assert.assertTrue("Im not at the cheap tickets home page", );
    }

}
