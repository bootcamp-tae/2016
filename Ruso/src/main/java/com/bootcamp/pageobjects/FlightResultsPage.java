package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * @author Juan Krzemien
 */
public class FlightResultsPage extends PageObjectBase {

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> selectButtons;

    public FlightResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFlight(int index) {
        getWait().until(visibilityOfAllElements(selectButtons));
        click(selectButtons.get(index));
    }
}
