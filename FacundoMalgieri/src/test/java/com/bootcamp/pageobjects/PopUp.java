package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUp extends PageObjectBase {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement modal;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement noThanks;

    public PopUp(WebDriver driver) {
        super(driver);
    }

    public FlightResult close() {
        click(noThanks);
        return new FlightResult(getDriver());
    }

    public boolean isThere() {
        return exists(this.modal);
    }


}