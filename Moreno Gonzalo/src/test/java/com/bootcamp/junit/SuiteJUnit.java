package com.bootcamp.junit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.CheapTicketsHomePage;
import pageObjects.FlightResultsPage;
import pageObjects.FlightSearchForm;

import java.util.Arrays;

/**
 * Created by Colegio on 19/12/2016.
 */

@RunWith(Parameterized.class)
public class SuiteJUnit {

    private WebDriver driver;

    public SuiteJUnit(WebDriver driver){ this.driver = driver; }

    @Parameterized.Parameters(name = "{index}:Browser[{0}]")
    public static Iterable<Object[]> data(){
        //FirefoxDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
            //{new FirefoxDriver()},
            {new ChromeDriver()}}
        );

    }


    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to("http://cheaptickets.com");
    }

    /*@After
    public void tearDown() {
        driver.quit();
    }*/


    @Test
    public void flightSearch() throws InterruptedException{

        CheapTicketsHomePage home = new CheapTicketsHomePage(driver);
        FlightSearchForm searchForm = home.clickOnFlightTab();
        FlightResultsPage results =   searchForm.doSearch("LAS", "LAX", 7, 7);

        results.selectDepartureFlight(4).selectReturnFlight(2);
        //FlightResultsPage ulti =;





    }


}

