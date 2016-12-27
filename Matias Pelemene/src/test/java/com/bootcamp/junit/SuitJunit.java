package com.bootcamp.junit;

import PageObjets.CheapTicketHome;
import PageObjets.FlightResultPage;
import PageObjets.FlightSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */
public class SuitJunit {

    @Test
    public void FlightSearch() {
        CheapTicketHome homePage = new CheapTicketHome();
        FlightSearchForm searchForm = homePage.ClickFlightTab();
        FlightResultPage resultPage = searchForm.DoSearch("LAX", "LAS", 7, 7);
        resultPage.SelectFlightOrigin(2).SelectFlightReturn(3);

    }
}
