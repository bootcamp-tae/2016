package com.bootcamp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class FlightResultsPage extends PageObjectBase {

    @FindBy (css = "button[data-test-id='select-button']")
    private List<WebElement> botonesSelect;

    public FlightResultsPage selectFlight(int i) {
        algo(i);
        return new FlightResultsPage(getDriver());
    }

    public PageObjectBase selectFlight2(int i) {
        algo(i);
        return this;
    }

    private void algo(int i){
        PopUp pop = new PopUp(getDriver());

        getWait().until(ExpectedConditions.visibilityOfAllElements(botonesSelect));

        if (pop.isVisible()) {
            pop.dismiss();
        }

        getWait().until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(notifications)));

        WebElement boton = botonesSelect.get(i);
        clickIt(boton);

        if (pop.isVisible()) {
            pop.dismiss();
        }

        getWait().pollingEvery(1, TimeUnit.SECONDS).until(ExpectedConditions.stalenessOf(boton));
    }

    private final By notifications = By.cssSelector("div.notification");

    public FlightResultsPage (WebDriver driver) {
        super(driver);
    }
}
