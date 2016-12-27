package com.bootcamp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class CheapTicketsHome extends PageObjectBase {

    @FindBy (id = "tab-flight-tab")
    private WebElement flightTab;

    public FlightSearchForm clickOnFlightTab() {

        clickIt(flightTab);

        return new FlightSearchForm(getDriver());
    }

    public CheapTicketsHome (WebDriver driver) {

        super(driver);

    }
}