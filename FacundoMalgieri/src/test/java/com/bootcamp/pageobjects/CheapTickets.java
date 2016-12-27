package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets extends PageObjectBase {
    private static final String CHEAPTICKETS_URL = "http://www.cheaptickets.com";

    @FindBy(id = "tab-flight-tab")
    private WebElement FlightTab;

    public CheapTickets(WebDriver driver) {
        super(driver);
        driver.navigate().to(CHEAPTICKETS_URL);

    }

    public FlightSearch clickOnFlightTab() {
        click(FlightTab);
        return new FlightSearch(getDriver());
    }

}
