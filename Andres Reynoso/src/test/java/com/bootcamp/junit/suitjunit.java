package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTicketHome;
import com.bootcamp.pageobjects.FlightResultPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */
public class suitjunit {

    @Test
   public void flightSearch() {

       CheapTicketHome home = new CheapTicketHome();

       FlightSearchForm searchForm = home.clickOnFlightTab();

       searchForm.doSearch("Lax", "Las", 7, 7);

       FlightResultPage results = new FlightResultPage();

       results.selectFlight(4);

   }
}