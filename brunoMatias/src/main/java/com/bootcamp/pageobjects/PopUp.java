package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Matias on 27/12/2016.
 */

public class PopUp {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement popUp;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement noThanksButton;

    //public PopUp (WebDriver driver) { super(driver); }

    public boolean popUpYes () {
        return popUp.isDisplayed();
    }

    /*public void popUpNo () {
        Click(noThanksButton);
    }*/


}
