package com.bootcamp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by leonardoluisvicario on 23/12/16.
 */
public class PopUp extends PageObjectBase {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement popup;

    @FindBy (id = "forcedChoiceNoThanks")
    private WebElement botonNo;

    public boolean isVisible () {
        return popup.isDisplayed();
    }

    public void dismiss () {
        clickIt(botonNo);
    }

    public PopUp(WebDriver d) {
        super(d);
    }
}
