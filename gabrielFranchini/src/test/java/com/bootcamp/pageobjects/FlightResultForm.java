package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Gabriel on 12/21/2016.
 */
public class FlightResultForm extends PageObjectBase {

    private final By notifications = By.cssSelector("div.notification");

    @FindBy(css = "button[data-test-id='select-button']")
    private List<WebElement> selectButtons;

    private PopUp flightPlusHotelPopUp;

    public FlightResultForm(WebDriver driver) {
        super(driver);
        this.flightPlusHotelPopUp = new PopUp(getDriver());
    }

    public FlightResultForm selectDepartureFlight(int index) {
        selectFlight(index);
        return new FlightResultForm(getDriver());
    }

    public ReviewTripPage selectReturnFlight(int index) {
        selectFlight(index);
        return new ReviewTripPage(getDriver());
    }

    private void selectFlight(int index) {
        getWait().until(visibilityOfAllElements(selectButtons));
        click(selectButtons.get(index - 1));
    }


    @Override
    protected void click(WebElement element) {
        if (flightPlusHotelPopUp.isVisible()) {
            flightPlusHotelPopUp.dismiss();
        }

        getWait().until(invisibilityOfElementLocated(notifications));

        super.click(element);

        if (flightPlusHotelPopUp.isVisible()) {
            flightPlusHotelPopUp.dismiss();
        }
    }
}
