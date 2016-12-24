package com.bootcamp.pageobjects;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PopUp extends Base {

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