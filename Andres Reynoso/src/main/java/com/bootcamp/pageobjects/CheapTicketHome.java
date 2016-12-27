package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.temporal.WeekFields;

/**
 * Created by Colegio on 21/12/2016.
 */
public class CheapTicketHome extends PageObjectBase {

    /*public CheapTicketHome() {

        driver.navigate().to("https://www.cheaptickets.com/");

    }*/

    @FindBy(id = "tab-flight-tab")
    private WebElement flightTab;

    public CheapTicketHome(WebDriver webDriver) {
        super(webDriver);
    }

    public FlightSearchForm clickOnFlightTab() {
        clic(flightTab);
        return new FlightSearchForm(driver);

    }
}
