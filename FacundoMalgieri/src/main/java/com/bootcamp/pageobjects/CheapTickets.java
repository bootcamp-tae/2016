package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheapTickets extends Base {

    @FindBy(id = "tab-flight-tab")
    private WebElement FlightTab;

    public CheapTickets() {
        getDriver().navigate().to("http://www.cheaptickets.com");
    }

    public FlightSearch clickOnFlightTab() {
        click(FlightTab);
        return new FlightSearch(getDriver());
    }

}
