package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Facu on 29/12/2016.
 */
public class ReviewTrip extends PageObjectBase {

    private static final String PAGE_TITLE = "Trip Detail | CheapTickets";

    @FindBy(css = "#FlightUDPBookNowButton1 > button")
    private WebElement continueBooking;

    public ReviewTrip(WebDriver driver) {
        super(driver);
        getWait().until(numberOfWindowsToBe(2));
        final String currentHandler = driver.getWindowHandle();
        driver.getWindowHandles().forEach(h -> {
            if (!h.equals(currentHandler) && !PAGE_TITLE.equals(getDriver().getTitle())) {
                driver.switchTo().window(h);
            }
        });
    }
    public boolean isVisible() {
        return continueBooking.isDisplayed();
    }
    public void continueBooking() {
        click(continueBooking);
    }

}
