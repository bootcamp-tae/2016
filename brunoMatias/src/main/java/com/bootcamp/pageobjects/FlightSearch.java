package com.bootcamp.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightSearch extends Base {
    @FindBy(id = "flight-origin")
    private WebElement from;

    @FindBy(id = "flight-destination")
    private WebElement to;

    @FindBy(id = "flight-departing")
    private WebElement when;

    @FindBy(id = "flight-returning")
    private WebElement until;

    @FindBy(id = "search-button")
    private WebElement submit;

    public FlightSearch(WebDriver driver) {
        super(driver);
    }

    public FlightResult doSearch(String origin, String destination, int departure, int back) {

        Type(from, origin);
        Type(to, destination);
        Type(when, calculateDate(departure).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        Type(until, calculateDate(departure + back).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        Click(submit);

        return new FlightResult(driver);
    }

    private LocalDateTime calculateDate(int a) {
        return LocalDateTime.now().plusDays(a);
    }

}
