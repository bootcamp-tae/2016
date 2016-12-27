package com.bootcamp.junit;
import com.bootcamp.pageobjects.CheapTicketHome;
import com.bootcamp.pageobjects.FlightResultPage;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Colegio on 19/12/2016.
 */
public class suitjunit {

    @Test
   public void flightSearch() {

        CheapTicketHome home = new CheapTicketHome();

        FlightSearchForm searchForm = home.clickOnFlightTab();

        FlightResultPage results = searchForm.doSearch("Las", "Lax", 7, 7);

        results.selectFlight(4).selectFlight(2);

   }
}