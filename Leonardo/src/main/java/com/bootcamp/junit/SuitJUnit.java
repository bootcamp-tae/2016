package com.bootcamp.junit;
import com.bootcamp.pageObjects.CheapTicketsHome;
import com.bootcamp.pageObjects.FlightResultsPage;
import com.bootcamp.pageObjects.FlightSearchForm;
import org.junit.Test;

/**
 * Created by Colegio on 19/12/2016.
 */
public class SuitJUnit {

    @Test
    public void flightSearch () {

        // instancia que se encuentra en el home (PageObject)
        CheapTicketsHome home = new CheapTicketsHome ();

        // seleccion del tab flight y lo almaceno (PageObject)
        FlightSearchForm searchForm = home.clickOnFlightTab();

        // dentro de cuantos dias salimos y cuantos dias nos quedamos (fecha q volvemos) (PageObject)
        FlightResultsPage result = searchForm.doSearch("LAS", "LAX", 7, 7);

        // elijo el 4to elemento dentro del page object
        result.selectFlight(4);

    }
}
