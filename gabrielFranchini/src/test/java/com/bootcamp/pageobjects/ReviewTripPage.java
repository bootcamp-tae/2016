package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

/**
 * @author Juan Krzemien
 */
public class ReviewTripPage extends PageObjectBase {

    private static final String PAGE_TITLE = "Trip Detail | CheapTickets";

    @FindBy(css = "#FlightUDPBookNowButton1 > button")
    private WebElement continueBooking;

    public ReviewTripPage(WebDriver driver) {
        super(driver);
        /*
         * Review Trip Details page opens up a new window.
         * We need to switch WebDriver's focus to the NEW window, which is the other one that is not the current one.
         */
        getWait().until(numberOfWindowsToBe(2));
        final String currentHandler = driver.getWindowHandle();
        driver.getWindowHandles().forEach(h -> {
            if (!h.equals(currentHandler) && !PAGE_TITLE.equals(getDriver().getTitle())) {
                driver.switchTo().window(h);
            }
        });
    }

    public void continueBooking() {
        click(continueBooking);
    }
}
