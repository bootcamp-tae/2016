package com.bootcamp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheapTickets extends Base {

    //with the BEFORE anotation, it's no necessary browse to the init page

    //seach the Flight Tab element
    @FindBy(id = "tab-flight-tab")
    private WebElement FlightTab;

    //it's a beautiful constructor, isn't it?
    public CheapTickets (WebDriver driver){
        super(driver);
    }

    //aaaaaand click on it!
    public FlightSearch clickOnFlightTab() {
        Click(FlightTab);
        return new FlightSearch(driver);
    }
}
