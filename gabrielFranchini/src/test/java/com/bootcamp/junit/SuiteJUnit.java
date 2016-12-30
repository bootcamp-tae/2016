package com.bootcamp.junit;

import com.bootcamp.framework.runner.junit.WebAutomationJUnitSuite;
import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultForm;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */


public class SuiteJUnit extends WebAutomationJUnitSuite<CheapTicketsHome> {

    @Test
        public void flightSearch() {
            CheapTicketsHome home = getStartingPage();

            FlightSearchForm searchForm = home.clickOnFlightTab();

            FlightResultForm result = searchForm.doSearch("LAS", "LAX", 7, 7);

            result.selectDepartureFlight(6)
                    .selectReturnFlight(3)
                    .continueBooking();
        }
    }
