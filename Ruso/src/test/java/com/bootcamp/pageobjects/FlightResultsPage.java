package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
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

    private PopUp flightPlusHotelPopUp;

    private Notifications notifications;

    public FlightResultsPage(WebDriver driver) {
        super(driver);
        this.notifications = new Notifications(getDriver());
        this.flightPlusHotelPopUp = new PopUp(getDriver());
    }

    public FlightResultsPage selectDepartureFlight(int index) {
        selectFlight(index);
        return new FlightResultsPage(getDriver());
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
        while (notifications.areDisplayed()) {
            notifications.dismiss();
        }
        super.click(element);
        if (flightPlusHotelPopUp.isVisible()) {
            flightPlusHotelPopUp.dismiss();
        }
    }
}
