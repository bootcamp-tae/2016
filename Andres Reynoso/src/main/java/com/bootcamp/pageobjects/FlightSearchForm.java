package com.bootcamp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Colegio on 21/12/2016.
 */
public class FlightSearchForm extends PageObjectBase {

    public FlightSearchForm(WebDriver driver) { super(driver); }

    @FindBy(id = "flight-origin")
    private WebElement from;
    @FindBy(id = "flight-destination")
    private WebElement to;
    @FindBy(id = "flight-departing")
    private WebElement departing;
    @FindBy(id = "flight-returning")
    private WebElement returning;
    @FindBy(id = "search-button")
    private WebElement button;

    public FlightResultPage doSearch(String origin, String destination, int d1, int d2){

        type(from, origin);
        type(to, destination);
        type(departing, calculateDate(d1, 0).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        type(returning, calculateDate(d1,d2).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        clic(button);
        return  new FlightResultPage(driver);

    }

    private LocalDateTime calculateDate(int days, int days2){

        return LocalDateTime.now().plusDays(days + days2);

    }
}