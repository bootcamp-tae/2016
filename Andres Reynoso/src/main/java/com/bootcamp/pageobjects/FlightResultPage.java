package com.bootcamp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightResultPage extends PageObjectBase {

    public FlightResultPage(WebDriver driver) {super(driver);}

    private AddHotelPopUp hotelPopUp = new AddHotelPopUp(getDriver());

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    public FlightResultPage selectFlight(int i) {

        selectFlightClickPopUp(buttons.get(i));
        return new FlightResultPage(getDriver());

    }

    public FlightResultPage selectFlightBack(int i) {

        selectFlightClickPopUp(buttons.get(i));
        return this;

    }

    private final By notifications = By.cssSelector("div.notification");

    protected void selectFlightClickPopUp (WebElement element){
        if (hotelPopUp.isPopUp()) {
            hotelPopUp.popUpClose();
        }
        getWait().until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(notifications)));
        super.clic(element);


        if (hotelPopUp.isPopUp()) {
            hotelPopUp.popUpClose();
        }
    }
}