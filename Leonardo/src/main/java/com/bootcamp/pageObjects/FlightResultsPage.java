package com.bootcamp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by leonardoluisvicario on 21/12/16.
 */
public class FlightResultsPage extends PageObjectBase {

    @FindBy (css = "button[data-test-id='select-button']")
    private List<WebElement> botonesSelect;

    public void selectFlight(int i) {

        wait.until(ExpectedConditions.visibilityOfAllElements(botonesSelect));
        clickIt(botonesSelect.get(i));
    }

    public FlightResultsPage (WebDriver driver) {
        super(driver);
    }
}
