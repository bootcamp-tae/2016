package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightResultPage extends PageObjectBase {

    public FlightResultPage(WebDriver driver) { super(driver); }

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> buttons;

    @FindBy(id = "forcedChoiceNoThanks")
    private WebElement popup;


    public FlightResultPage selectFlight(int i) {

        clickList(buttons, i);

        //return new FlightResultPage(driver);

        getWait().until(ExpectedConditions.invisibilityOfAllElements(buttons));

        //clickList(buttons, i);

        return new FlightResultPage(this.driver);

        //this.driver(return selectFlight(j));
    }
    /*public void selectFlight2 (int j) {

        getWait().until(ExpectedConditions.invisibilityOfAllElements(buttons));

        clickList(buttons, j);

    }*/

}