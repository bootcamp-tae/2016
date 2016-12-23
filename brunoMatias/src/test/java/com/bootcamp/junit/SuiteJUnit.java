package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import org.junit.Test;

public class SuiteJUnit {
    @Test
    public void FlightSearch() {

        CheapTickets home   = new CheapTickets();
        FlightSearch form   = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 7);
        result.selectFlight(4)
                .selectFlight(2);

    }
}
