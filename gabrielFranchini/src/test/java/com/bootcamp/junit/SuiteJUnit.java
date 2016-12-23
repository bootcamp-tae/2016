package com.bootcamp.junit;

import com.bootcamp.pageobjects.CheapTicketsHome;
import com.bootcamp.pageobjects.FlightResultForm;
import com.bootcamp.pageobjects.FlightSearchForm;
import org.junit.Test;


/**
 * Created by Colegio on 19/12/2016.
 */
public class SuiteJUnit {

    @Test
    public void flightSearch(){

        //ABRE CHROME Y NOS METE EN CHEAPTICKETS.COM
        CheapTicketsHome home = new CheapTicketsHome();
        //NOS METE EN LA TAB DE FLIGHT
        FlightSearchForm searchForm = home.clickOnFlightTab();
        //INTRODUCE ORIGEN Y DESTINO, LAS VEGAS A LOS ANGELES
        FlightResultForm result = searchForm.doSearch("LAS", "LAX", 7, 7);
        //SELECCIONA EL 4TO RESULTADO
        result.selectFlight(4);
        //RE CHETO
    }
}
