package com.bootcamp.junit;
import com.beust.jcommander.Parameters;
import com.bootcamp.pageObjects.CheapTicketsHome;
import com.bootcamp.pageObjects.FlightResultsPage;
import com.bootcamp.pageObjects.FlightSearchForm;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by Colegio on 19/12/2016.
 */
@RunWith(Parameterized.class)

public class SuitJUnit {

    private WebDriver browser;

    public SuitJUnit (WebDriver browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "{index}:Browser[{0}]")
    public static Collection<Object[]> data() {
        ChromeDriverManager.getInstance().setup();
        return Arrays.asList(new Object[][]{
                {new ChromeDriver()}
        });
    }

    @Before
    public void setUp () {
        browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        browser.navigate().to("http://www.cheaptickets.com");
    }

    @After
    public void tearDown () {
        browser.quit();
    }

    @Test
    public void flightSearch () throws InterruptedException {

        // instancia que se encuentra en el home (PageObject)
        CheapTicketsHome home = new CheapTicketsHome (browser);

        // seleccion del tab flight y lo almaceno (PageObject)
        FlightSearchForm searchForm = home.clickOnFlightTab();

        // dentro de cuantos dias salimos y cuantos dias nos quedamos (fecha q volvemos) (PageObject)
        FlightResultsPage result = searchForm.doSearch("LAS", "LAX", 7, 7);

        // elijo el 4to elemento dentro del page object
        FlightResultsPage nuevo = result.selectFlight(4);

        nuevo.selectFlight(6);

    }
}
