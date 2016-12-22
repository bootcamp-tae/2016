package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets extends Base {

    @FindBy(id = "tab-flight-tab")
    private WebElement FlightTab;

    public CheapTickets() {
        driver.navigate().to("http://www.cheaptickets.com");
    }

    public FlightSearch clickOnFlightTab() {
        this.FlightTab.click();
        return new FlightSearch(driver);
    }

}
