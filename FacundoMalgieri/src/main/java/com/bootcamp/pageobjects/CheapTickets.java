package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets {

    @FindBy(id = "tab-flight-tab")
    private WebElement FlightTab;

    public FlightSearch clickOnFlightTab() {
        this.FlightTab.click();
        return new FlightSearch();
    }

}
