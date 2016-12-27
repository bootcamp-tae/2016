package com.bootcamp.pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by leonardoluisvicario on 23/12/16.
 */
public class PopUp extends PageObjectBase {

    @FindBy(id = "xSellHotelForcedChoice")
    private WebElement popup;

    @FindBy (id = "forcedChoiceNoThanks")
    private WebElement botonNo;

    public boolean isVisible () {
        try {
            getWait().withTimeout(2, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(popup));
            return true;
        } catch (TimeoutException e) {
            return false;
        }

    }

    public void dismiss () {
        clickIt(botonNo);
    }

    public PopUp(WebDriver d) {
        super(d);
    }
}
