package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Juan Krzemien
 */
public class FlightSearchForm extends PageObjectBase {

    // Constants
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @FindBy(id = "flight-origin")
    private WebElement txtOrigin;

    @FindBy(id = "flight-destination")
    private WebElement txtDestination;

    @FindBy(id = "flight-departing")
    private WebElement txtDeparture;

    @FindBy(id = "flight-returning")
    private WebElement txtReturn;

    @FindBy(id = "search-button")
    private WebElement btnSearch;

    public FlightSearchForm(WebDriver driver) {
        super(driver);
    }

    public FlightResultsPage doSearch(String origin, String destination, int daysTilTrip, int daysToStayOnDestination) {

        type(txtOrigin, origin);
        type(txtDestination, destination);

        LocalDateTime departDate = dateFromToday(daysTilTrip);
        LocalDateTime returnDate = dateFromToday(daysTilTrip + daysToStayOnDestination);

        type(txtDeparture, departDate.format(DATE_FORMAT));
        type(txtReturn, returnDate.format(DATE_FORMAT));

        click(btnSearch);

        return new FlightResultsPage(getDriver());
    }

    private LocalDateTime dateFromToday(int plusDays) {
        // today + <plusDays> days
        return LocalDateTime.now().plusDays(plusDays);

    }
}
