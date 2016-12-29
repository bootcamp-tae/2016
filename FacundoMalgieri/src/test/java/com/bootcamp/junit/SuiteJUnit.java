package com.bootcamp.junit;
import com.bootcamp.framework.runner.junit.WebAutomationJUnitSuite;
import com.bootcamp.pageobjects.CheapTickets;
import com.bootcamp.pageobjects.FlightResult;
import com.bootcamp.pageobjects.FlightSearch;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

public class SuiteJUnit extends WebAutomationJUnitSuite<CheapTickets> {

    @Test
    public void FlightSearch() throws InterruptedException {
        CheapTickets home = getStartingPage();
        FlightSearch form = home.clickOnFlightTab();
        FlightResult result = form.doSearch("LAS", "LAX", 7, 9);
        result.selectDepartureFlight(7)
                .selectReturnFlight(7);
    }

}
