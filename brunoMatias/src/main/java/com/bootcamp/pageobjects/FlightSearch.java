package com.bootcamp.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    public FlightResult doSearch(String from, String to, int when, int until) {
        this.from.sendKeys(from + Keys.ENTER);
        this.to.sendKeys(to + Keys.ENTER);
        this.when.sendKeys(calculateDate(when).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        this.until.sendKeys(calculateDate(calculateDate(when), until).format(DateTimeFormatter.ofPattern("mm/dd/yyyy")));
        submit.click();
        return new FlightResult(driver);
    }

    private LocalDateTime calculateDate(int a) {
        return LocalDateTime.now().plusDays(a);
    }

    private LocalDateTime calculateDate(LocalDateTime date, int a) {
        return date.plusDays(a);
    }
}
