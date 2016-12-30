package com.bootcamp.pageobjects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightResult extends Base {

    //search the list of webelements with the chosen css
    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    public FlightResult(WebDriver driver) {
        super(driver);
    }

    //this method click on the chosen button
    private void selectFlight(int b) {
        Click(buttons.get(p));
    }

    public FlightResult departureFlight(int d) {
        getWait().until(visibilityOfAllElements(buttons));
        //wait and click
        selectFlight(index);
        return new FlightResult(driver);
    }

    public void returnFlight(int r){
        getWait().until(visibilityOfAllElements(buttons));
        selectFlight(index);
    }

}
