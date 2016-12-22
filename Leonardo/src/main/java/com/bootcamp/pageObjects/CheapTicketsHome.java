package com.bootcamp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class CheapTicketsHome extends PageObjectBase {

    @FindBy (id = "tab-flight-tab")
    private WebElement flightTab;

    public CheapTicketsHome () {

        driver.navigate().to("http://www.cheaptickets.com");

    }

    public FlightSearchForm clickOnFlightTab() {

        flightTab.click();
        return new FlightSearchForm(driver);
    }

    public CheapTicketsHome (WebDriver driver) {

        super(driver);

    }
}
