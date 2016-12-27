package com.bootcamp.pageobjects;

import com.bootcamp.framework.web.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightSearch extends PageObjectBase {
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

    public FlightResult doSearch(String f, String t, int w, int u) {
        LocalDateTime init = calculateDate(w);
        LocalDateTime end  = calculateDate(init, u);

        type(from,f);
        type(to,t);
        type(when,init.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        type(until,end.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        click(submit);
        return new FlightResult(getDriver());
    }

    private LocalDateTime calculateDate(int a) {
        return LocalDateTime.now().plusDays(a);
    }

    private LocalDateTime calculateDate(LocalDateTime date, int a) {
        return date.plusDays(a);
    }
}
