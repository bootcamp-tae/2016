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

    public FlightResultsPage selectFlight(int i) {

        PopUp pop = new PopUp(getDriver());

        getWait().until(ExpectedConditions.visibilityOfAllElements(botonesSelect));

        if (pop.isVisible()) {
            pop.dismiss();
        }

        clickIt(botonesSelect.get(i));

        return new FlightResultsPage(getDriver());
    }

    public FlightResultsPage (WebDriver driver) {
        super(driver);
    }
}
