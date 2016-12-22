package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightSearchForm extends PageObjectBase {

    public FlightSearchForm(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "flight-origin")
    private WebElement from;
    @FindBy(id = "flight-destination")
    private WebElement to;
    @FindBy(id = "flight-departing")
    private WebElement departing;
    @FindBy(id = "flight-returning")
    private WebElement returning;
    @FindBy (id="search-button")
    private WebElement button;


    public FlightResultPage doSearch(String origin, String destination, int d1, int d2) {
        from.sendKeys(origin);
        to.sendKeys(destination);
        departing.sendKeys(calculateDate(d1).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        returning.sendKeys(calculateDate(d1,d2).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        button.click();
        return new FlightResultPage();

    }

    private LocalDateTime calculateDate(int days) {

        return LocalDateTime.now().plusDays(days);

    }

    private LocalDateTime calculateDate(int days, int days2){

        return LocalDateTime.now().plusDays(days + days2);

    }


}
